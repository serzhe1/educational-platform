package com.edpl.cms.service.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class TokenFilterBean extends GenericFilterBean {

    @Autowired
    TokenAuthenticationProvider tokenAuthenticationProvider;

    @Override
    public void doFilter(ServletRequest req, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;

        try {
            // authenticate
            String header = request.getHeader("Authorization");
            if (StringUtils.hasText(header) && header.startsWith("Bearer ")) {
                try {
                    logger.debug("JWT Token " + header);
                    // extract token value
                    String token = header.split("\\s")[1].trim();
                    // validate token
                    com.edpl.cms.service.security.TokenAuthentication tokenAuthentication = new  com.edpl.cms.service.security.TokenAuthentication();
                    tokenAuthentication.setToken(token);

                    Authentication	authentication = tokenAuthenticationProvider.authenticate(tokenAuthentication);

                    if (authentication.isAuthenticated()) {
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    } else {
                        SecurityContextHolder.clearContext();
                    }

                } catch (AuthenticationException ex) {
                    logger.info("Authentication failed on header "+header, ex);
                    SecurityContextHolder.clearContext();
                }
            }/* else {
				customKeycloakAuthenticationHandler.onAuthenticationFailure(request, (HttpServletResponse)response, null);
				//((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}*/
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        chain.doFilter(request, response);
    }
}
