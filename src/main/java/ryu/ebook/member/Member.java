package ryu.ebook.member;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;
import ryu.ebook.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {

    private String password;

    private String nickname;
    private String email;

    public List<GrantedAuthority> genAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));

        if(StringUtils.hasText(nickname)) {   // 작가 필명(nickname) 이 있는 경우에만 권한 부여.
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_AUTHOR"));
        }
        return grantedAuthorities;
    }

}
