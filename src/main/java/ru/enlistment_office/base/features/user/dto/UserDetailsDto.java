package ru.enlistment_office.base.features.user.dto;


import ru.enlistment_office.base.features.user.entities.UserRole;

import java.util.Set;

public record UserDetailsDto(
        Integer id,
        String email,
        Set<UserRole> roles,
        UserAccountingDetailsDto accounting
) { }
