package br.com.perceptron.marketplace.usuario;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static java.util.Objects.nonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO {

    private String token;
    private Date expiration;
    private String audience;
    private String issuer;
    private Date issuedAt;

    public TokenDTO(Claims claims) {
        this.token = claims.getSubject();
        this.expiration = nonNull(claims.getExpiration()) ? claims.getExpiration() : null;
        this.audience = claims.getAudience();
        this.issuedAt = nonNull(claims.getIssuedAt()) ? claims.getIssuedAt() : null;
        this.issuer = claims.getIssuer();
    }
}
