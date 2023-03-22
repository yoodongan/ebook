package ryu.ebook.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ryu.ebook.member.Member;
import ryu.ebook.member.exception.AlreadyJoinException;
import ryu.ebook.member.repository.MemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Transactional
    public Member join(String username, String password, String email, String nickname) {
        Optional<Member> oMember = memberRepository.findByUsername(username);
        if (oMember.isPresent()) {
            throw new AlreadyJoinException();
        }
        Member member = Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .nickname(nickname)
                .build();
        memberRepository.save(member);
        return member;
    }
    public Optional<Member> findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

}
