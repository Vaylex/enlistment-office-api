package ru.enlistment_office.base.features.user.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.enlistment_office.base.common.mappers.Mappable;
import ru.enlistment_office.base.features.user.dto.placeWork.PlaceWorkDto;
import ru.enlistment_office.base.features.user.entities.placeWork.PlaceWorkEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlaceWorkMapper extends Mappable<PlaceWorkEntity, PlaceWorkDto> {}
