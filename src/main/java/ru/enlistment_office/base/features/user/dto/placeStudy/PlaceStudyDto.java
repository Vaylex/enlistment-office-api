package ru.enlistment_office.base.features.user.dto.placeStudy;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PlaceStudyDto {

    private String name;
    private Integer currentCourse;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean postponement = false;
}
