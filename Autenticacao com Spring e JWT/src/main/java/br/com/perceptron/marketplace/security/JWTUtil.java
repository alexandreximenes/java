package br.com.perceptron.marketplace.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

import static br.com.perceptron.marketplace.security.Headers.BEARER;
import static java.util.Objects.nonNull;

@Service
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.audience}")
    private String audience;

    private String token;

    public String getToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setIssuer(username)
                .setAudience(audience)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    public boolean tokenIsValid(String token) {
        Claims claims = getClaims(token);
        if (nonNull(claims) && tokenIsExpirated(claims)) {
            return true;
        }
        return false;
    }

    public boolean tokenIsExpirated(Claims claims) {
        String username = claims.getSubject();
        Date expiration = claims.getExpiration();
        Date now = new Date(System.currentTimeMillis());
        if (nonNull(username) && nonNull(expiration) && now.before(expiration))
            return true;
        return false;
    }

    private Claims getClaims(String token) {
        this.token = token.replace(BEARER, "");
        return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);
        if (nonNull(claims))
            return claims.getSubject();
        return null;
    }

    public Claims refreshToken(String username) {
        String token = this.getToken(username);
        return getClaims(token);
    }
}
