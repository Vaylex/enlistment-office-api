package ru.enlistment_office.base.features.user.security.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import ru.enlistment_office.base.features.user.entities.UserRole;

import java.util.Collection;
import java.util.Set;

@Getter
@Setter
public class JwtAuthentication implements Authentication {

    @Getter
    private Integer id;
    private boolean authenticated;
    private String email;
    private Set<UserRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return roles; }

    @Override
    public Object getCredentials() { return null; }

    @Override
    public Object getDetails() { return null; }

    @Override
    public Object getPrincipal() { return email; }

    @Override
    public boolean isAuthenticated() { return authenticated; }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() { return email; }
}
