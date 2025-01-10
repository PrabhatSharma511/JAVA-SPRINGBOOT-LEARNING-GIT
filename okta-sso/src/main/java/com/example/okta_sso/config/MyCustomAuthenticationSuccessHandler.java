//package com.example.okta_sso.config;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Component;
//
//import com.example.okta_sso.models.AuthResponse;
//
//@Component
//public class MyCustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Autowired
//    private OAuth2AuthorizedClientService authorizedClientService;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws IOException, ServletException {
//        OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
//        OAuth2AuthorizedClient client = authorizedClientService
//                .loadAuthorizedClient("okta", oidcUser.getName());
//
//        List<String> authorities = oidcUser.getAuthorities().stream()
//                .map(grantedAuthority -> grantedAuthority.getAuthority())
//                .collect(Collectors.toList());
//
//        AuthResponse authResponse = AuthResponse.builder()
//                .accessToken(client.getAccessToken().getTokenValue())
//                .userId(oidcUser.getEmail())
//                .refreshToken(client.getRefreshToken() != null ? client.getRefreshToken().getTokenValue() : null)
//                .expiredAt(client.getAccessToken().getExpiresAt().getEpochSecond())
//                .authorities(authorities)
//                .build();
//
//        // Store AuthResponse in session
//        HttpSession session = request.getSession();
//        session.setAttribute("authResponse", authResponse);
//
//        response.sendRedirect("/authenticate"); // Redirect to /authenticate endpoint
//    }
//}
