package ru.enlistment_office.base.features.user.dto.passport;

import lombok.Getter;
import lombok.Setter;
import ru.enlistment_office.base.features.user.entities.passport.Gender;

import java.time.LocalDate;

@Getter
@Setter
public class PassportDto {

    private String issued;
    private LocalDate dateIssue;
    private String series;
    private String number;
    private String first_name;
    private String last_name;
    private String middle_name;
    private Gender gender;
    private LocalDate birthday;
    private String addressCity;
    private String addressStreet;
    private String addressHouseNumber;
    private Integer addressApartmentNumber;

}
