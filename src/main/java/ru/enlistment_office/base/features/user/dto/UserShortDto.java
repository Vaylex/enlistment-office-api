package ru.enlistment_office.base.features.user.dto;

public record UserShortDto(
        Integer id,
        String firstName,
        String lastName,
        String middleName,
        String email
) {}
