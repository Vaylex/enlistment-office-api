package ru.enlistment_office.base.features.enlistmentSummonDocument.entities;

import jakarta.persistence.*;
import lombok.Data;
import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingEntity;

import java.time.LocalDate;

@Data
@Entity(name = "enlistment_summon_documents")
public class EnlistmentSummonDocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private EnlistmentSummonDocumentType type;
    private LocalDate sendDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private UserAccountingEntity accounting;
}
