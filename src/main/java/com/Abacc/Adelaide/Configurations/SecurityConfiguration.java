package com.Abacc.Adelaide.Configurations;

import com.Abacc.Adelaide.Services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserRegistrationService userRegistrationService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userRegistrationService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers(
//				"/registration**",
//				"/contact**",
//				"/index**",
//				"/css/**",
//				"/images/**",
//				"/js/**",
//				"/scss/**"
//		)..anonymous().and().formLogin().loginPage("/memberlogin")
//				.permitAll().and()
//				.logout().invalidateHttpSession(true).clearAuthentication(true)
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutSuccessUrl("/memberlogin?logout").permitAll();
//	}

	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				"/registration**",
				"/adminreg**",
				"/contact**",
				"/index**",
				"/css/**",
				"/images/**",
				"/js/**",
				"/scss/**"
		).permitAll().anyRequest().authenticated().
				and().formLogin().loginPage("/memberlogin")
				.permitAll().and()
				.logout().invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/memberlogin?logout").permitAll();
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin**").hasAuthority("ROLE_Admin")
				.antMatchers(
				"/registration**",
				"/regadmin",
				"/about**",
				"/contact**",
				"/index**",
				"/css/**",
				"/images/**",
				"/js/**",
				"/scss/**"
		).permitAll().anyRequest().authenticated().
				and().formLogin().loginPage("/memberlogin")
				.permitAll().and()
				.logout().invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/memberlogin?logout").permitAll();
	}


}
