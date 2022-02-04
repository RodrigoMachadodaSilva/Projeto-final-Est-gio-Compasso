package com.compasso.duvidas.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.compasso.duvidas.entities.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${duvidas.jwt.expiration}")
	private String expiration;

	@Value("${duvidas.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		return Jwts.builder().setIssuer("Api de Controle do Programa de Bolsas da Compasso/UOl")
				.setSubject(logado.getId().toString()).setIssuedAt(hoje).setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

}
