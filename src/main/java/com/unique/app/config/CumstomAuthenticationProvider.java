package com.unique.app.config;

import com.unique.app.main.service.MemberService;
import com.unique.app.user.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
@RequiredArgsConstructor
public class CumstomAuthenticationProvider implements AuthenticationProvider {
    private MemberService memberService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id   = authentication.getName();
        String pw   = (String) authentication.getCredentials();

        log.debug("id ===== "+id);
        log.debug("pw ===== "+pw);

        MemberDTO loginDto  = new MemberDTO();
        loginDto.setId(id);
        loginDto.setPw(pw);
        MemberDTO memberDto  = memberService.findLoginInfo(loginDto);

        if(memberDto == null) {
            log.info("USER 데이터 조회 불가");
            throw new BadCredentialsException("Login Error");
        }

        ArrayList<SimpleGrantedAuthority> authorities   = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+memberDto.getRole()));

        log.info("AUTH CHECK === "+authorities.toString());
        log.info("AUTH CHECK === "+memberDto);

        return new UsernamePasswordAuthenticationToken(memberDto, null, authorities);
    }

    /**
     * token 타입에 따라 언제 provider 를 사용할지 조건 지정
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
