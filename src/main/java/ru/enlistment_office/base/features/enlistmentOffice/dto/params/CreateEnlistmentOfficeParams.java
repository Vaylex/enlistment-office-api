package ru.enlistment_office.base.features.enlistmentOffice.dto.params;

public record CreateEnlistmentOfficeParams(
        String city,
        String street,
        String houseNumber
) {}
