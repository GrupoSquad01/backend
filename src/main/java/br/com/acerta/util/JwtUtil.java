package br.com.acerta.util;

import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private long expirationTime;
	
	@SuppressWarnings("deprecation")
	public String generateToken(String login) {
		return Jwts.builder()
				.setSubject(login)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expirationTime))
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	
	public String generateRefreshToken(String login) {
        return generateToken(login);
    }
	
	public String getUsernameFromToken(String token) {
        try {
            if (!token.matches("^[A-Za-z0-9-_\\.]+\\.[A-Za-z0-9-_\\.]+\\.[A-Za-z0-9-_\\.]+$")) {
                System.out.println("Token JWT malformatado: " + token);
                throw new IllegalArgumentException("Token JWT malformatado.");
            }

            return extractClaim(token, Claims::getSubject);
        } catch (Exception e) {
            System.out.println("Erro ao extrair o username do token: " + e.getMessage());
            throw e;
        }
    }
	
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    @SuppressWarnings("deprecation")
	private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        try {
            final String username = extractUsername(token);
            return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
        } catch (Exception error){
            return false;
        }
    }
}
