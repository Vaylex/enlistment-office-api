package ru.enlistment_office.base.features.user.entities.placeStudy;

import jakarta.persistence.*;
import lombok.Data;
import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingEntity;

import java.time.LocalDate;

@Data
@Entity(name = "place_study")
public class PlaceStudyEntity {

    @Id
    private Integer id;

    private String name;
    private Integer currentCourse;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean postponement = false;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private UserAccountingEntity accounting;
}
