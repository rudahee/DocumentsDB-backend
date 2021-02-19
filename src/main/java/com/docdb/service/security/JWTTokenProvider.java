package com.docdb.service.security;

import java.util.Date;

import javax.crypto.SecretKey;

import com.docdb.model.entity.User;
import com.docdb.service.common.SecurityConstants;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JWTTokenProvider {
private static SecretKey key; 
	
	public static String generateToken(User user) {
        return Jwts.builder()
				.setHeaderParam(Header.TYPE, Header.JWT_TYPE)
				.setSubject(user.getEmail().toString())
				.setId(user.getId().toString())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.claim("updateTime", user.getUpdateTime())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(getKey(), SignatureAlgorithm.HS512)
				.compact();
	}
	
	public static Integer getIdFromToken(String token) {
		return Integer.parseInt((String) Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("jti"));
	}
	
	public static boolean validateToken(String token) {
		boolean valid = false;
		try {
			Jwts.parser().setSigningKey(getKey()).parseClaimsJws(token);
			valid = true;
		}catch (Exception e) {
			System.out.println("Token not valid: " + token);
		}
		return valid;
	}
	
	public static SecretKey getKey() {
		if(key== null) {
			key = Keys.hmacShaKeyFor(SecurityConstants.SECRET.getBytes());
		}
		return key;
	}
}
