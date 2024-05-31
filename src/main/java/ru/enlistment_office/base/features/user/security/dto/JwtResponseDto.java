package ru.enlistment_office.base.features.user.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.enlistment_office.base.features.user.entities.UserRole;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponseDto {

    private Integer userId;
    private Set<UserRole> roles;
    private final String type = "Bearer";
    private String accessToken;
}
