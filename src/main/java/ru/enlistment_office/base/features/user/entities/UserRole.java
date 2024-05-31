package ru.enlistment_office.base.features.user.entities;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum UserRole implements GrantedAuthority {
    BASE_USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
