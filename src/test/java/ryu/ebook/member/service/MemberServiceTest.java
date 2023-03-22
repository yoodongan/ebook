package ryu.ebook.member.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import ryu.ebook.member.Member;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("회원 가입 테스트")
    void t1() {
        String username = "userA";
        String password = "1234";
        String email = "userA519@naver.com";
        memberService.join(username, password, email, null);

        Member findMember = memberService.findByUsername("userA").get();
        Assertions.assertThat(findMember.getUsername()).isEqualTo("userA");
        Assertions.assertThat(passwordEncoder.matches(password, findMember.getPassword())).isTrue();

    }


}