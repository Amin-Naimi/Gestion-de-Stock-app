package com.example.versuion.jwt;

import com.example.versuion.models.auth.ExtendedUser;
import com.example.versuion.services.auth.ApplicationUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

    private String SECRET_KEY = "SecrteKeyNA32/3#ISET";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public String extractIdEntreprise(String token) {
        final Claims claims = extractAllClaims(token);

        return claims.get("idEntreprise", String.class);
    }

    //Extraire des proprites à partir d'un token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    //Extraire Toutes les proprites à partir d'un token

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(ExtendedUser user) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, user);
    }

    private String createToken(Map<String, Object> claims, ExtendedUser user) {

        return Jwts.builder().setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10 * 10))
                .claim("idEntreprise", user.getIdEntreprise().toString())//Stocker lid entreprise dans le token por l utiliser dans lintercepte
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (
                username.equals(userDetails.getUsername())
                        && !isTokenExpired(token)
        );
    }

}