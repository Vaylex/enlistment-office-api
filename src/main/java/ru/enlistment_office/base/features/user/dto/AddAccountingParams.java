package ru.enlistment_office.base.features.user.dto;

import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingMaritalStatus;
import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingStatus;

public record AddAccountingParams(
        Integer enlistmentOfficeId,
        UserAccountingStatus status,
        UserAccountingMaritalStatus maritalStatus,
        String phoneNumber,
        Integer phoneNumberCode
) {}
