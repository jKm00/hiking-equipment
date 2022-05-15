package no.ntnu.xxs.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;

import no.ntnu.xxs.entities.user.User;

/**
 * A utility class for handling JWT token
 */
@Component
public class JwtUtil {
    @Value("${jwt_secret_key}")
    private String SECRET_KEY;
    /**
     * This is the key inside the JWT token that stores all the roles
     */
    private static final String JWT_AUTH_KEY = "roles";
    //private static final String JWT_ID_KEY = "ueid";
    // TODO: add user id to token
    public String generateToken(UserDetails userDetails) {
        final long CURRENT_TIME = System.currentTimeMillis();
        final long HOUR_IN_MILLISECOND = 60 * 60 * 1000;
        final long TIME_AFTER_ONE_HOUR = CURRENT_TIME + HOUR_IN_MILLISECOND;

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim(JWT_AUTH_KEY, userDetails.getAuthorities())
                //.claim(JWT_ID_KEY, user.getId())
                .setIssuedAt(new Date(CURRENT_TIME))
                .setExpiration(new Date(TIME_AFTER_ONE_HOUR))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /**
     * Gets the username from a JWT token
     *
     * @param token the JWT token
     * @return the username as a String
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        try {
            final Claims claims = extractAllClaims(token);
            return claimsResolver.apply(claims);
        } catch (SignatureException | ExpiredJwtException e) {
            return null;
        }
    }

    /**
     * Returns all claims in the token
     *
     * @param token the token to extract claims from
     * @return all claims in token
     * @throws SignatureException if parser failed to parse token, this exception is thrown. For example
     * if an invalid token is submitted in a request.
     */
    private Claims extractAllClaims(String token) throws SignatureException, ExpiredJwtException {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    /**
     * Checks is a JWT token has expired
     *
     * @param token the JWT token to check
     * @return {@code true} if token has expired, {@code} false otherwise.
     */
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Gets the expiration date from the JWT token
     *
     * @param token the JWT token
     * @return a date object with the expiration date in the JWT token
     */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Validates the token given with the user given
     *
     * @param token the JWT token to validate
     * @param userDetails details of the user
     * @return {@code true} if the token matches the user, and it is still valid
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
}
