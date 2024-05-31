package ru.enlistment_office.base.features.user.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.enlistment_office.base.common.mappers.Mappable;
import ru.enlistment_office.base.features.enlistmentOffice.mappers.EnlistmentOfficeMapper;
import ru.enlistment_office.base.features.enlistmentSummonDocument.dto.EnlistmentSummonDocumentShortDto;
import ru.enlistment_office.base.features.user.dto.UserAccountingDetailsDto;
import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
        EnlistmentOfficeMapper.class, PlaceWorkMapper.class, PlaceStudyMapper.class, PassportMapper.class,
        EnlistmentSummonDocumentShortDto.class
})
public interface UserAccountingDetailsMapper extends Mappable<UserAccountingEntity, UserAccountingDetailsDto> {}
