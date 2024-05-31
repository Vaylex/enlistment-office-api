package ru.enlistment_office.base.features.enlistmentSummonDocument.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.enlistment_office.base.common.mappers.Mappable;
import ru.enlistment_office.base.features.enlistmentSummonDocument.dto.EnlistmentSummonDocumentShortDto;
import ru.enlistment_office.base.features.enlistmentSummonDocument.entities.EnlistmentSummonDocumentEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EnlistmentSummonDocumentShortMapper extends Mappable<EnlistmentSummonDocumentEntity, EnlistmentSummonDocumentShortDto> {}
