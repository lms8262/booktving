package com.ezen.booktving.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.ezen.booktving.handler.CustomOAuth2SuccessHandler;
import com.ezen.booktving.service.PrincipalOauth2UserService;

import lombok.RequiredArgsConstructor;

@Configuration // Bean 객체를 싱글톤으로 객체를 관리해준다.
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final UserDetailsService userDetailsService;

	private final PrincipalOauth2UserService principalOauth2UserService;

	private final DataSource dataSource;

	/*
	 * public SecurityConfig(PrincipalOauth2UserService principalOauth2UserService,
	 * UserDetailsService userDetailsService, DataSource dataSource) {
	 * this.principalOauth2UserService = principalOauth2UserService; this.dataSource
	 * = dataSource; this.userDetailsService = userDetailsService; }
	 */

	@Bean
	MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
		return new MvcRequestMatcher.Builder(introspector);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {

		http.authorizeHttpRequests(authorize -> authorize // 페이지 접근에 관한
				// 모든 사용자가 로그인(인증) 없이 접근할수 있도록 설정
				.requestMatchers(mvc.pattern("/css/**"), mvc.pattern("/js/**"), mvc.pattern("/images/**"), mvc.pattern("/fontawesome-free-6.3.0-web/**")).permitAll()
				.requestMatchers(mvc.pattern("/"), mvc.pattern("/favicon.ico"), mvc.pattern("/error"), mvc.pattern("/image/**")).permitAll()
				.requestMatchers(mvc.pattern("/membership/**"), mvc.pattern("/login/**")).permitAll()
				.requestMatchers(mvc.pattern("/findid"), mvc.pattern("/findpw")).permitAll()
				.requestMatchers(mvc.pattern("/category/**"), mvc.pattern("/search/**"), mvc.pattern("/question/**")).permitAll()
				.requestMatchers(mvc.pattern("/author/**"), mvc.pattern("/book/**"), mvc.pattern("/mylibrary/**"),mvc.pattern("/mypage/**")).permitAll()
				// 'admin'으로 시작하는 경로는 관리자만 접근가능하도록 설정
				.requestMatchers(mvc.pattern("/admin/**")).hasRole("ADMIN")
				.anyRequest().authenticated())// 그외 페이지는 모두 로그인 (인증을 받아야한다.)
				.formLogin(formLogin -> formLogin// 2.로그인에 관련된 설정
						.loginPage("/login")// 로그인페이지 URL설정
						.defaultSuccessUrl("/")// 로그인 성공시 이동할 페이지
						.usernameParameter("userId")// 로그인시 id로 사용할 파라메터 이름
						.failureUrl("/login/error"))// 로그인 실패시 이동할 url
				.oauth2Login(oauth2 -> oauth2.loginPage("/login").successHandler(oauth2AuthenticationSuccessHandler())
						.failureUrl("/login/error")
						.userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint.userService(principalOauth2UserService)))
				.logout(logout -> logout// 3.로그아웃에 관련된 설정
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/"))// 로그아웃 성공시
				// 이동할 URL
				// 4.인증 되지 않은 사용자가 리소스에 접근했을때 설정(ex.로그인 안했는데 cart페이지에 접근..)
				.exceptionHandling(handling -> handling.authenticationEntryPoint(new CustomAuthenticationEntryPoint()))
				.rememberMe(Customizer.withDefaults())
				.rememberMe(rememberMe -> rememberMe.rememberMeParameter("remember-me").tokenValiditySeconds(3600)
						.alwaysRemember(false).tokenRepository(tokenRepository())
						.userDetailsService(userDetailsService));

		return http.build();
	}

	@Bean
	public AuthenticationSuccessHandler oauth2AuthenticationSuccessHandler() {
		return new CustomOAuth2SuccessHandler();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
		jdbcTokenRepository.setDataSource(dataSource);
		return jdbcTokenRepository;
	}

}