package com.reddict.reddictClone.security;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PublicKey;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.reddict.reddictClone.exceptions.SpringRedditException;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import static io.jsonwebtoken.Jwts.parser;

@Service
@RequiredArgsConstructor
public class JwtProvider {

	private final JwtEncoder jwtEncoder;
	@Value("${jwt.expiration.time}")
	private Long jwtExpirationInMillis;
	private KeyStore keyStore;

	public String generateToken(Authentication authentication) {
		User principal = (User) authentication.getPrincipal();
		return generateTokenWithUserName(principal.getUsername());
	}

	public String generateTokenWithUserName(String username) {
		JwtClaimsSet claims = JwtClaimsSet.builder().issuer("self").issuedAt(Instant.now())
				.expiresAt(Instant.now().plusMillis(jwtExpirationInMillis)).subject(username)
				.claim("scope", "ROLE_USER").build();

		return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	}

	public Long getJwtExpirationInMillis() {
		return jwtExpirationInMillis;
	}

	private PublicKey getPublickey() {
		try {
			return keyStore.getCertificate("springblog").getPublicKey();
		} catch (KeyStoreException e) {
			throw new SpringRedditException("Exception occured while retrieving public key from keystore");
		}
	}

}
