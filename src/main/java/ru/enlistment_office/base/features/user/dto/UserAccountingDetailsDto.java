package ru.enlistment_office.base.features.user.dto;

import ru.enlistment_office.base.features.enlistmentOffice.dto.EnlistmentOfficeDto;
import ru.enlistment_office.base.features.enlistmentSummonDocument.dto.EnlistmentSummonDocumentShortDto;
import ru.enlistment_office.base.features.user.dto.passport.PassportDto;
import ru.enlistment_office.base.features.user.dto.placeStudy.PlaceStudyDto;
import ru.enlistment_office.base.features.user.dto.placeWork.PlaceWorkDto;
import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingMaritalStatus;
import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingStatus;

import java.util.Collection;

public record UserAccountingDetailsDto(
        UserAccountingStatus status,
        UserAccountingMaritalStatus maritalStatus,
        String phoneNumber,
        Integer phoneNumberCode,
        EnlistmentOfficeDto enlistmentOffice,
        PlaceWorkDto work,
        PlaceStudyDto study,
        PassportDto passport,
        Collection<EnlistmentSummonDocumentShortDto> enlistmentSummonDocuments
) {}
