package ru.enlistment_office.base.features.user.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.enlistment_office.base.common.mappers.Mappable;
import ru.enlistment_office.base.features.user.dto.UserShortDto;
import ru.enlistment_office.base.features.user.entities.UserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserShortMapper extends Mappable<UserEntity, UserShortDto> {

    @Override
    @Mapping(source = "entity.accounting.passport.first_name", target = "firstName")
    @Mapping(source = "entity.accounting.passport.last_name", target = "lastName")
    @Mapping(source = "entity.accounting.passport.middle_name", target = "middleName")
    UserShortDto toDto(UserEntity entity);
}
