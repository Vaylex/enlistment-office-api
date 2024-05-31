package ru.enlistment_office.base.features.user.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.enlistment_office.base.common.mappers.Mappable;
import ru.enlistment_office.base.features.user.dto.placeStudy.PlaceStudyDto;
import ru.enlistment_office.base.features.user.entities.placeStudy.PlaceStudyEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlaceStudyMapper extends Mappable<PlaceStudyEntity, PlaceStudyDto> {}
