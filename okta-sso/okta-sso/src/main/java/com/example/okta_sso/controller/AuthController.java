package com.example.okta_sso.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.okta_sso.models.AuthResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/login")
    public ResponseEntity<?> login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser user) {
        
        try {
            // Validate OAuth2 client and user
            if (client == null || user == null) {
                logger.error("OAuth2 client or user information is missing.");
                return new ResponseEntity<>("Authentication information is missing or invalid.", HttpStatus.UNAUTHORIZED);
            }

            logger.info("Authenticated user email: {}", user.getEmail());
            
            List<String> authorities = user.getAuthorities().stream()
                    .map(grantedAuthority -> grantedAuthority.getAuthority())
                    .collect(Collectors.toList());

            // Build the AuthResponse object
            AuthResponse response = AuthResponse.builder()
                    .accessToken(client.getAccessToken().getTokenValue())
                    .userId(user.getEmail())
                    .refreshToken(client.getRefreshToken() != null ? client.getRefreshToken().getTokenValue() : "N/A")
                    .expiredAt(client.getAccessToken().getExpiresAt().getEpochSecond())
                    .authorities(authorities)
                    .build();
            
            return ResponseEntity.ok(response);

        } catch (Exception e) {
        	
            logger.error("Error during login processing: {}", e.getMessage(), e);
            return new ResponseEntity<>("An error occurred during login processing.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Global exception handler for this controller
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("Exception handled at global level: {}", e.getMessage(), e);
        return new ResponseEntity<>("An internal error occurred. Please contact support.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/home")
    public ResponseEntity<String> home() {
        logger.info("Accessed /auth/home");
        return ResponseEntity.ok("Welcome to the home page!");
    }
}
