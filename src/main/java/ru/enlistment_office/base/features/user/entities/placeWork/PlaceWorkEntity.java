package ru.enlistment_office.base.features.user.entities.placeWork;

import jakarta.persistence.*;
import lombok.Data;
import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingEntity;

@Data
@Entity(name = "place_works")
public class PlaceWorkEntity {

    @Id
    private Integer id;

    private String organization;
    private String position;
    private Boolean postponement = false;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private UserAccountingEntity accounting;
}
