package com.appsdeveloperblog.photoapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private Environment env;
	
	@Autowired
	UsersService userService;
	
	@Autowired
	BCryptPasswordEncoder bcp;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/users/**").permitAll().and().addFilter(getAuthenticationFilter());
		//http.authorizeRequests().antMatchers("/**").hasIpAddress(env.getProperty("gateway.ip")).and().addFilter(getAuthenticationFilter());
		http.headers().frameOptions().disable();
	}


	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter auth = new AuthenticationFilter(userService,env,authenticationManager());
		//auth.setAuthenticationManager(authenticationManager());
		auth.setFilterProcessesUrl(env.getProperty("login.url.path"));
		return auth;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bcp);
	}
	
	
	
}
