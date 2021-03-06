package com.docdb.service.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.docdb.model.entity.User;
import com.docdb.model.entity.dto.UserDTO;
import com.docdb.service.common.SecurityConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebFilter
public class AuthJWT extends UsernamePasswordAuthenticationFilter {

	private static AuthenticationManager authenticationManager;
	
	@SuppressWarnings("static-access")
	public AuthJWT(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl(SecurityConstants.SIGN_IN);
    }
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		UserDTO user = null;
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), UserDTO.class);

		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InternalAuthenticationServiceException e) {
			System.out.println("Authentication Failed");
		}
		
		return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				user.getUsername(), user.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
        response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + 
        		JWTTokenProvider.generateToken(((User)authResult.getPrincipal())));
		
	}
}
