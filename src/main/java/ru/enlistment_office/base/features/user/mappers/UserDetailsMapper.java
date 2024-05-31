package ru.enlistment_office.base.features.user.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.enlistment_office.base.common.mappers.Mappable;
import ru.enlistment_office.base.features.user.dto.UserDetailsDto;
import ru.enlistment_office.base.features.user.entities.UserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = UserAccountingDetailsMapper.class)
public interface UserDetailsMapper extends Mappable<UserEntity, UserDetailsDto> { }
