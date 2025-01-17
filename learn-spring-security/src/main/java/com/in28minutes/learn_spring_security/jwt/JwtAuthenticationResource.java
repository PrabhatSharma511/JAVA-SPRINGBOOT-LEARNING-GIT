package com.in28minutes.learn_spring_security.jwt;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class JwtAuthenticationResource {
	
	@Autowired
	JwtEncoder jwtEncoder;

	@PostMapping("/authenticate")
	public JsonResponse authenticate(Authentication authentication) {
		return new JsonResponse(createToken(authentication));
	}

	private String createToken(Authentication authentication) {
		var claims = JwtClaimsSet.builder()
					.issuer("self")
					.issuedAt(Instant.now())
					.expiresAt(Instant.now().plusSeconds(15*60))
					.subject(authentication.getName())
					.claim("scope",createScope(authentication))
					.build();
		
		JwtEncoderParameters parameters = JwtEncoderParameters.from(claims);
		return jwtEncoder.encode(parameters).getTokenValue();
		
	}

	private String createScope(Authentication authentication) {
		return authentication.getAuthorities().stream().map(a->a.getAuthority()).collect(Collectors.joining(" "));
		
	}
	
}

record JsonResponse(String token) {};
