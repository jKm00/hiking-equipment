package no.ntnu.xxs.security;

/**
 * A class for the data the server will send back after the client has sent a successful login request
 */
public class AuthenticationResponse {
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return this.jwt;
    }
}
