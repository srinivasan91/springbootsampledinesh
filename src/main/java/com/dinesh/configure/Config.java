package com.dinesh.configure;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
public class Config {

	@Bean
	public AuthenticationEntryPoint getAuthenticationEntryPoint() {
		return new AuthenticationEntryPoint() {
			
			@Override
			public void commence(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException authException) throws IOException, ServletException {
		        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		        PrintWriter writer = response.getWriter();
		        writer.println("HTTP Status 401 - UserName and Password Incorrect " + authException.getMessage());
			}
		};
		
	}

}
