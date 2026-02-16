package org.apatrios.api.dictionary.purchase_type.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.purchase_type.dto.PurchaseTypeDto;
import org.apatrios.api.dictionary.purchase_type.dto.SearchPurchaseTypeDto;
import org.apatrios.model.dictoinary.PurchaseType;
import org.apatrios.service.dictionary.argument.SearchPurchaseTypeArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseTypeMapper extends BaseDictionaryMapper<PurchaseType, PurchaseTypeDto, SearchPurchaseTypeDto, SearchPurchaseTypeArgument> {
}
