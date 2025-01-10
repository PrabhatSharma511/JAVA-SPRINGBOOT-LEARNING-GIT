package com.example.okta_sso.models;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {

	private String userId;
	
	private String accessToken;
	
	private String refreshToken;
	
	private long expiredAt;
	
	private Collection<String> authorities;
	
}
