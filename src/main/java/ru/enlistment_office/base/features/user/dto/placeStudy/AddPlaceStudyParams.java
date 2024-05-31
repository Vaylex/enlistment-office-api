package ru.enlistment_office.base.features.user.dto.placeStudy;

import java.time.LocalDate;

public record AddPlaceStudyParams(
   String name,
   Integer currentCourse,
   Boolean postponement,
   LocalDate startDate,
   LocalDate endDate
) {}
