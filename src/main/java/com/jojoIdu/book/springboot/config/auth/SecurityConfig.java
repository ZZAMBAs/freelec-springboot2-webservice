package com.jojoIdu.book.springboot.config.auth;

import com.jojoIdu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable() // h2-console 화면 사용을 위해 disable 하는 것들.
                .and()
                .authorizeRequests() // URL 별 권한 관리를 설정하는 옵션 시작점. 이 선언이 있어야 antMatchers를 사용할 수 있다.
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                // antMatchers는 권한 관리 대상을 지정하는 옵션이다. 여기서는 지정 URL들에 permitAll 옵션으로 전체 열람 권한을 주었다.
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // USER 권한 가진 사람만 열람가능하도록 한 경우이다.
                .anyRequest().authenticated() // anyRequest는 설정값들 이외 나머지 URL들을 말한다. authenticated를 통해 인증된 사용자들에게만 허용하게 하였다.
                .and()
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService); // oauth2Login은 OAuth2 로그인 기능 진입점이다.
        // userInfoEndpoint는 로그인 이후 사용자 정보를 가져올 때 설정들을 담당한다.
    }
}
