package ru.enlistment_office.base.features.enlistmentOffice.entities;

import jakarta.persistence.*;
import lombok.Data;
import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingEntity;

import java.util.List;

@Data
@Entity(name = "enlistment_offices")
public class EnlistmentOfficeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String city;
    private String street;
    private String houseNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "enlistmentOffice")
    private List<UserAccountingEntity> UserAccounts;
}
