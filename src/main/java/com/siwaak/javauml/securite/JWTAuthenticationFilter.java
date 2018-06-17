package com.siwaak.javauml.securite;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.siwaak.javauml.utilisateur.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.siwaak.javauml.securite.SecurityConstants.EXPIRATION_TIME;
import static com.siwaak.javauml.securite.SecurityConstants.HEADER_STRING;
import static com.siwaak.javauml.securite.SecurityConstants.SECRET;
import static com.siwaak.javauml.securite.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
	private AuthenticationManager authenticationManager;
   // @Autowired
    private UtilisateurRepository utilisateurRepository;


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager,UtilisateurRepository utilisateurRepository) {
        this.authenticationManager = authenticationManager;
        this.utilisateurRepository=utilisateurRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            Utilisateur creds = new ObjectMapper()
                    .readValue(req.getInputStream(), Utilisateur.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();
        String email = ((User) auth.getPrincipal()).getUsername();
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();        
        out.print(ow.writeValueAsString(utilisateur));
        out.flush();
    }
}