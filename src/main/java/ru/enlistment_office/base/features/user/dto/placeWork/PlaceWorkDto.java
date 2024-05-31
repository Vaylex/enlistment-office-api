package ru.enlistment_office.base.features.user.dto.placeWork;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceWorkDto {
    private String organization;
    private String position;
    private Boolean postponement = false;
}
