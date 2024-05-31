package ru.enlistment_office.base.features.user.entities.passport;

import jakarta.persistence.*;
import lombok.Data;
import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingEntity;

import java.time.LocalDate;

@Data
@Entity(name = "passports")
public class PassportEntity {

    @Id
    private Integer id;

    private String issued;
    private LocalDate dateIssue;
    private String series;
    private String number;
    private String first_name;
    private String last_name;
    private String middle_name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate birthday;
    private String addressCity;
    private String addressStreet;
    private String addressHouseNumber;
    private Integer addressApartmentNumber;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private UserAccountingEntity accounting;
}
