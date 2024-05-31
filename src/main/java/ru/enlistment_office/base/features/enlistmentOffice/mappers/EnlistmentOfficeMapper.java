package ru.enlistment_office.base.features.enlistmentOffice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.enlistment_office.base.common.mappers.Mappable;
import ru.enlistment_office.base.features.enlistmentOffice.dto.EnlistmentOfficeDto;
import ru.enlistment_office.base.features.enlistmentOffice.entities.EnlistmentOfficeEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EnlistmentOfficeMapper extends Mappable<EnlistmentOfficeEntity, EnlistmentOfficeDto> {}