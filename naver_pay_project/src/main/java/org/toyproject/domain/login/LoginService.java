package org.toyproject.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.toyproject.domain.member.MemberRepository;
import java.lang.reflect.Member;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    /*
     *  @return null 이면 로그인 실패
     */

    public Member login (String loginId, String password) {
        return memberRepository.findByLonginId(loginId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);

    }
}
