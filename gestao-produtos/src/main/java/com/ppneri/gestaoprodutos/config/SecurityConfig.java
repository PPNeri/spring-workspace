package com.ppneri.gestaoprodutos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public class SecurityConfig {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder)
	throws Exception {
	builder
	.inMemoryAuthentication()
	.withUser("pedro").password("{noop}123").roles("USER")
	.and()
	.withUser("lari").password("{noop}123").roles("USER")
	.and()
	.withUser("thiago").password("{noop}123").roles("ADMIN");
}


}
