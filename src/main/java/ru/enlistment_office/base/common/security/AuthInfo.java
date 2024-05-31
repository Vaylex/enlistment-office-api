package ru.enlistment_office.base.common.security;

import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.enlistment_office.base.features.user.entities.UserRole;
import ru.enlistment_office.base.features.user.security.JwtProvider;
import ru.enlistment_office.base.features.user.security.dto.JwtAuthentication;

import static ru.enlistment_office.base.features.user.security.JwtFilter.getTokenFromRequest;

@Component
@RequiredArgsConstructor
public class AuthInfo {

    private final JwtProvider jwtProvider;

    public boolean hasIsAdmin(HttpServletRequest request) {
        JwtAuthentication authentication = getAuthInfo(request);

        for (UserRole role : authentication.getRoles()) {
            if(role == UserRole.ADMIN) return true;
        }

        return false;
    }

    @SneakyThrows
    public JwtAuthentication getAuthInfo(HttpServletRequest request) {
        final String token = getTokenFromRequest(request);

        if(token != null && jwtProvider.validateAccessToken(token)){
            return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
        }

        throw new AuthException();
    }
}
