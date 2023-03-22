package ryu.ebook.security.dto;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import ryu.ebook.member.Member;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class MemberContext extends User {
    private final Long id;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;
    private final String username;
    private final String nickname;
    private final String email;

    public MemberContext(Member member, List<GrantedAuthority> authorities) {
        super(member.getUsername(), member.getPassword(), authorities);
        this.id = member.getId();
        this.createdDate = member.getCreatedDate();
        this.modifiedDate = member.getModifiedDate();
        this.username = member.getUsername();
        this.nickname = member.getNickname();
        this.email = member.getEmail();
    }
    public boolean hasAuthority(String name) {
        return getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(name));
    }


}