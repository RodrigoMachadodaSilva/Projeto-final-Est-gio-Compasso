package com.compasso.duvidas.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
	
	private String email;
	private String senha;
	
	
	public UsernamePasswordAuthenticationToken converter() {
		return  new UsernamePasswordAuthenticationToken(senha, email);
	}

}
