package ru.enlistment_office.base.features.user.security;

import io.jsonwebtoken.Claims;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.enlistment_office.base.features.user.entities.UserRole;
import ru.enlistment_office.base.features.user.security.dto.JwtAuthentication;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JwtUtils {

    public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication jwtInfoToken = new JwtAuthentication();
        jwtInfoToken.setRoles(getRoles(claims));
        jwtInfoToken.setEmail(claims.get("email", String.class));
        jwtInfoToken.setId(claims.get("id", Integer.class));
        return jwtInfoToken;
    }

    private static Set<UserRole> getRoles(Claims claims) {
        final List<String> roles = claims.get("roles", List.class);
        return roles.stream()
                .map(UserRole::valueOf)
                .collect(Collectors.toSet());
    }

}