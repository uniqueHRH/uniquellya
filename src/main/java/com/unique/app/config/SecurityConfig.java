package com.unique.app.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration          // config 파일 선언
@EnableWebSecurity      // security 사용 선언
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private CumstomAuthenticationProvider authenticationProvider;

    /*
    Spring Security가 사용자를 인증하는 방법이 담긴 객체
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);    // 로그인 정보를 확인하고, 권한정보 확인 -> 인증 토큰 발행
    }

    /*
    Spring Security rule을 무시하게 하는 URL 규칙 (rule 미적용)
     */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers();
//    }

    /*
    Spring Security rule
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()    // 보호된 리소스 URI에 접근할 수 있는 권한 설정
                .antMatchers("/login/**").permitAll()
                .antMatchers("/myPage").hasRole("A")
                .anyRequest().authenticated()       // 인증이 필요하다는 설정
            .and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("login/loginCheck")
                .defaultSuccessUrl("/main")
                .failureUrl("/login/loginFail")
                .usernameParameter("id")
                .passwordParameter("pwd")
                .permitAll()                    // 반드시. 설정하지 않으면, 권한 문제가 있는 경우 로그인 화면에 들어갈 수 없음
            .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)    // 로그아웃시 session 초기화
            .and().csrf()
                .disable()                      // 설정이 어떻게 되는지 모르니 일단 disabled 처리 -> 차후 변경 필요
            .exceptionHandling()
                .accessDeniedPage("/login/denied")
                ;
    }
}

/*
[ authorizeRequests ]
.permitAll() 또는 denyAll()          // 접근전체 허용 또는 제한
.hasRole() 또는 hasAnyAuthority()    // 특정권한만 접근 인가
.anonymous()                        // 누구나 접근 가능
.fullyAuthenticated()               // 완전 인증된 사용자만 접근 가능
.hasIpAddress()                     // 특정 ip를 가진 사용자만 접근 가능
.not()                              // 접근제한기능 해제
.rememberMe()                       // 로그인한 사용자만 접근 가능. 리멤버기능
                                    // 아이디나 토큰을 기억하는 것이 아니라, 로그인 정보를 유지하는 방법 -> 비권장
[ login / logout ]
.loginPage()                        // 사용자 정의 로그인 페이지
.loginProcessingUrl()               // 사용자 이름&암호를 제출할 URL
.defaultSuccessUrl()                // 성공적인 로그인 후 랜딩 페이지
.failureUrl()                       // 로그인 실패 후 랜딩 페이지
.successForwardUrl()                // 로그인 성공 후 보내는 Url
.defaultSuccessUrl()                // 인증이 필요한 페이지에 접근하면 로그인 페이지로 리다이렉트
                                    // 로그인 성공시 첫 접근 페이지로 리다이렉트
.logoutUrl()                        // 사용자 정의 로그아웃 페이지
.logoutRequestMatcher(new AntPathRequestMatcher()   // 커스텀 로그아웃 페이지

[ csrf ]
restAPI 에서는 csrf 공격으로부터 안전하고, 매번 API 요청으로부터 csrf 토큰을 받지 않아도 될 경우 disabled()
.csrf().disable()                       // csrf 보안 설정 비활성화
                                        // 해당 기능을 사용하기 위해서는 프론트단에서 csrf 토큰값을 보내줘야 함

[ filter ]
Spring Security의 FilterComparator에 등록된 filter들을 활성화시킬 때 사용
.addFilter(jwAuthorizationFilter())     // Form Login에 사용되는 custom AuthenticationFilter 구현체 등록
.addFilter(jwAuthorizationFilter())     // Header 인증에 사용되는 BasicAuthenticationFilter 구현체 등록
*/
