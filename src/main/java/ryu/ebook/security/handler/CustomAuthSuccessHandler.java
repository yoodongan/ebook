package ryu.ebook.security.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import ryu.ebook.security.dto.MemberContext;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final RequestCache requestCache = new HttpSessionRequestCache();
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        clearSession(request);
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        /* 기존 세션의 prevPage 속성 제거 */
        String prevPage = (String) request.getSession().getAttribute("prevPage");
        if (prevPage != null) {
            request.getSession().removeAttribute("prevPage");
        }

        String url = "/";
        if(savedRequest != null) url = savedRequest.getRedirectUrl();
        else if(prevPage != null && prevPage.length() > 0) {
            if(prevPage.contains("/member/join") || prevPage.contains("/member/login") || prevPage.contains("/member/logout")) {
                url = "/";
            } else url = prevPage;
        }
        MemberContext memberContext = (MemberContext) authentication.getPrincipal();
        redirectStrategy.sendRedirect(request, response, url);

    }

    private void clearSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // 에러 세션 제거를 위해 찾아온다.
        if(session != null) session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}
