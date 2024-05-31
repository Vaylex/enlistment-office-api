package ru.enlistment_office.base.features.user.entities.accounting;

import jakarta.persistence.*;
import lombok.Data;
import ru.enlistment_office.base.features.enlistmentOffice.entities.EnlistmentOfficeEntity;
import ru.enlistment_office.base.features.enlistmentSummonDocument.entities.EnlistmentSummonDocumentEntity;
import ru.enlistment_office.base.features.user.entities.UserEntity;
import ru.enlistment_office.base.features.user.entities.passport.PassportEntity;
import ru.enlistment_office.base.features.user.entities.placeStudy.PlaceStudyEntity;
import ru.enlistment_office.base.features.user.entities.placeWork.PlaceWorkEntity;

import java.util.Collection;

@Data
@Entity(name = "user_accountings")
public class UserAccountingEntity {

    @Id
    private Integer id;

    @Enumerated(EnumType.STRING)
    private UserAccountingStatus status;

    @Enumerated(EnumType.STRING)
    private UserAccountingMaritalStatus maritalStatus;

    private String phoneNumber;
    private Integer phoneNumberCode;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    private EnlistmentOfficeEntity enlistmentOffice;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "accounting", cascade = CascadeType.ALL)
    private PlaceWorkEntity work;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "accounting", cascade = CascadeType.ALL)
    private PlaceStudyEntity study;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "accounting", cascade = CascadeType.ALL)
    private PassportEntity passport;

    @OneToMany(mappedBy = "accounting", fetch = FetchType.LAZY)
    private Collection<EnlistmentSummonDocumentEntity> enlistmentSummonDocuments;
}
