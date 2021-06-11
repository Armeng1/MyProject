package th.ac.rmutsb.pro.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Created by nydiarra on 06/05/17.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig 
	extends WebSecurityConfigurerAdapter {

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
//        .authorizeRequests()
//        .anyRequest().authenticated()
//        .and()
        //.addFilterBefore(new JwtAuthenticationFilter(this.tokenService),UsernamePasswordAuthenticationFilter.class)
		.csrf()
        .disable();
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**", "/configuration/security", "/swagger-ui.html", "/webjars/**");
	}
	
}
