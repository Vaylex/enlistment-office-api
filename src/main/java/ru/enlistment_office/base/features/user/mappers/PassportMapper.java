package ru.enlistment_office.base.features.user.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.enlistment_office.base.common.mappers.Mappable;
import ru.enlistment_office.base.features.user.dto.passport.PassportDto;
import ru.enlistment_office.base.features.user.entities.passport.PassportEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PassportMapper extends Mappable<PassportEntity, PassportDto> {}
