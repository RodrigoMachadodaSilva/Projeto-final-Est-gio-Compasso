package com.compasso.duvidas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.duvidas.config.security.TokenService;
import com.compasso.duvidas.dto.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	
	@PostMapping
	public ResponseEntity<?> autenticar (@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		
		
		try {
			System.out.println("aqui\naqui\naqui\n");
		    Authentication authentication = authManager.authenticate(dadosLogin);
		    String token = tokenService.gerarToken(authentication);
		    System.out.println(token);
            return ResponseEntity.ok().build();
	    } catch (AuthenticationException e) {
	    	System.out.println("aqui\naqui\naqui\n");
	    	
	    	return ResponseEntity.badRequest().build();
	    }
		
	}

}
