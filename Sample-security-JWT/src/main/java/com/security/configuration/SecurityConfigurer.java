package com.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.service.MyUserDetailsService;

//@SuppressWarnings(value = {""})
//@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends  WebSecurityConfigurerAdapter {
	
	/*
	 * @Autowired private JwtUserDetailsService jwtUserDetailsService;
	 * 
	 * @Autowired private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	 * 
	 * @Autowired private JwtAuthenticationFilter jwtAuthenticationFilter;
	 */
     @Autowired
	 private MyUserDetailsService myUserDetailsService;
    
     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
    	auth.userDetailsService(myUserDetailsService);
	 }
     
     @Bean
     public PasswordEncoder passwordEncoder() {
    	 return  NoOpPasswordEncoder.getInstance();
     }
	
		/*
		 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
		 * Exception { auth.userDetailsService(jwtUserDetailsService).passwordEncoder(
		 * passwordEncoder()); }
		 * 
		 * 
		 * @Bean
		 * 
		 * @Override public AuthenticationManager authenticationManagerBean() throws
		 * Exception { return super.authenticationManagerBean(); }
		 * 
		 * @Bean public PasswordEncoder passwordEncoder() { return new
		 * BCryptPasswordEncoder(); }
		 * 
		 * @Override public void configure(WebSecurity web) throws Exception { ((Object)
		 * web.ignoring()).antMatchers(HttpMethod.OPTIONS, "/**"); }
		 * 
		 * @Override protected void configure(HttpSecurity http) throws Exception {
		 * http.csrf().disable() .authorizeRequests()
		 * .antMatchers("/api/authenticate").permitAll() .antMatchers(HttpMethod.POST,
		 * "/api/users").permitAll() .anyRequest().authenticated() .and()
		 * .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
		 * .and()
		 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 * 
		 * http.addFilterBefore(jwtAuthenticationFilter,
		 * UsernamePasswordAuthenticationFilter.class); }
		 */

}
