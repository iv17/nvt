package nvt.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Goran Savić
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureAuthentication(
			AuthenticationManagerBuilder authenticationManagerBuilder)
			throws Exception {
		
		authenticationManagerBuilder
				.userDetailsService(this.userDetailsService).passwordEncoder(
						passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public AuthenticationTokenFilter authenticationTokenFilterBean()
			throws Exception {
		AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
		authenticationTokenFilter
				.setAuthenticationManager(authenticationManagerBean());
		return authenticationTokenFilter;
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers(HttpMethod.POST, "/api/users/login").permitAll() 
				.antMatchers(HttpMethod.POST, "/api/users/registration").permitAll() 
		
				.antMatchers("/h2/**").permitAll()	//h2
				.and().csrf().disable();//OBAVEZNO
		
		httpSecurity.headers().frameOptions().disable();	//h2

		httpSecurity.addFilterBefore(authenticationTokenFilterBean(),
				UsernamePasswordAuthenticationFilter.class);
	}
	/**
	 * If we use AngularJS as a client application, it will send CSRF token using 
	 * name X-XSRF token. We have to tell Spring to expect this name instead of 
	 * X-CSRF-TOKEN (which is default one)
	 * @return
	 */
//	private CsrfTokenRepository csrfTokenRepository() {
//		  HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//		  repository.setHeaderName("X-XSRF-TOKEN");
//		  return repository;
//	}
}
