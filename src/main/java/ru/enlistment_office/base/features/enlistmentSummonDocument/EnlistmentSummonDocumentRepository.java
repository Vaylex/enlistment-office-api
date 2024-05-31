package ru.enlistment_office.base.features.enlistmentSummonDocument;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.enlistment_office.base.features.enlistmentSummonDocument.entities.EnlistmentSummonDocumentEntity;

public interface EnlistmentSummonDocumentRepository extends JpaRepository<EnlistmentSummonDocumentEntity, Integer> { }
