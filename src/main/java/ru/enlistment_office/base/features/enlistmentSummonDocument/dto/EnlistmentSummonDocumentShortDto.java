package ru.enlistment_office.base.features.enlistmentSummonDocument.dto;

import ru.enlistment_office.base.features.enlistmentSummonDocument.entities.EnlistmentSummonDocumentType;

import java.time.LocalDate;

public record EnlistmentSummonDocumentShortDto(
   Integer id,
   EnlistmentSummonDocumentType type,
   LocalDate sendDate
) {}
