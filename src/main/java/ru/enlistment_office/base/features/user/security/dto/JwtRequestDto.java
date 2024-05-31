package ru.enlistment_office.base.features.user.security.dto;

public record JwtRequestDto(
        String email,
        String password
) {}
