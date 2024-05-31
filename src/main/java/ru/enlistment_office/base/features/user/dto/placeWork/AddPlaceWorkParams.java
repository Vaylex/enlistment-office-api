package ru.enlistment_office.base.features.user.dto.placeWork;

public record AddPlaceWorkParams(
        String organization,
        String position,
        Boolean postponement
) {}
