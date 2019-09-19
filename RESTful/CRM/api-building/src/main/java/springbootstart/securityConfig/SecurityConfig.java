package springbootstart.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*http
			.authorizeRequests()
				.antMatchers("/css/**", "/index").permitAll()		
				.antMatchers("/user/**").hasRole("USER")			
				.and()
			.formLogin()
				.loginPage("/login").failureUrl("/login-error");*/
		auth.userDetailsService(userDetailsService);

	}

	@Autowired
	protected void configure(HttpSecurity http) throws Exception {
		/*auth
			.inMemoryAuthentication()
				.withUser("Bob").password("secret").roles("USER");*/
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/").permitAll()
		.and().formLogin();
	}
}
