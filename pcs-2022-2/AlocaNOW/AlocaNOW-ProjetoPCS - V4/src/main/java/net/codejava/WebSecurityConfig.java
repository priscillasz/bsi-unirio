package net.codejava;

import net.codejava.usuario.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth
				.userDetailsService(userDetailsService())
				.passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/javax.faces.resource/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/login", "/oauth/**", "/").permitAll()
			.antMatchers("/edit/**", "/delete/**").hasAnyRole("CHAMPION", "GERENTE", "PROFISSIONAL")
			.anyRequest().authenticated()
			.and()
			.formLogin().permitAll()
				.loginPage("/login")
				.usernameParameter("email")
				.passwordParameter("pass")
				.defaultSuccessUrl("/menu") //era users
			/*.and()
				.oauth2Login()
				.loginPage("/login")
				.userInfoEndpoint()
				.userService(oauthUserService)
				.and()
				.successHandler(new AuthenticationSuccessHandler() {

					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
														Authentication authentication) throws IOException, ServletException {
						// teste p/ verificar o nome do usuário autenticado
						System.out.println("AuthenticationSuccessHandler invoked");
						System.out.println("Authentication name: " + authentication.getName());
						CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
						// userService.processOAuthPostLogin(oauthUser.getEmail());

						// verificar se o email do usuário está no bd
						boolean emailExiste = userService.emailExists(oauthUser.getEmail());

						if (emailExiste) {
							System.out.println("Email no db!");
							response.sendRedirect("/users");
						} else {
							System.out.println("Email não está no db!");
							response.sendRedirect("/logout"); // TODO consertar

						}

						*//*if (oauthUser.getEmail().equals("priscillaxtp@edu.unirio.br")) {
							System.out.println("Email ok");
							System.out.println(oauthUser.getEmail());
							response.sendRedirect("/list");
						} else {
							System.out.println("Barrado!!!");
							System.out.println(oauthUser.getEmail());
							response.sendRedirect("/logout");
						}*//*

						// response.sendRedirect("/list");
					}
				})*/
				.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			;
	}

	/*@Autowired
	private CustomOAuth2UserService oauthUserService;

	@Autowired
	private UserService userService;*/
}
