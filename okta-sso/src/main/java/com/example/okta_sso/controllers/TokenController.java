package com.example.okta_sso.controllers;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class TokenController {
    private static final Logger logger = LoggerFactory.getLogger(TokenController.class);


    @GetMapping("/get-custom-claim")
    public RedirectView handleCustomClaim(@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client) {
        String redirectUrl = getClaimAndDetermineRedirect(client);
        return new RedirectView(redirectUrl); // Return a RedirectView with the determined URL
    }

    private String getClaimAndDetermineRedirect(OAuth2AuthorizedClient client) {
        String token = client.getAccessToken().getTokenValue();
        logger.warn("Token found for user: {}", token);
        JwtDecoder jwtDecoder = JwtDecoders.fromIssuerLocation("https://dev-67221612.okta.com/oauth2/default"); // Replace with your Okta issuer URL
        Jwt decodedJwt = jwtDecoder.decode(token);

        // Extract the custom claim as a list of values
        List<String> myClaimValue = decodedJwt.getClaimAsStringList("roles");
        logger.warn("Claim 'roles' values: {}", myClaimValue);

        // Redirect based on claim values
        return determineRedirectUrl(myClaimValue);
    }
    
    private String determineRedirectUrl(List<String> myClaimValue) {
        if (myClaimValue != null) {
            for (String value : myClaimValue) {
                String normalizedValue = value.toLowerCase(); // Convert to lowercase for case-insensitive matching
                if (normalizedValue.contains("admin")) {
                    return "http://localhost:3000/admin";
                } else if (normalizedValue.contains("normal")) {
                    return "http://localhost:3000/normal";
                }
            }
        }
        // Default redirect URL if no matching criteria are met
        return "https://www.google.co.in/";
    }
}
