package org.apatrios.api.dictionary.purchase_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.purchase_type.dto.PurchaseTypeDto;
import org.apatrios.api.dictionary.purchase_type.dto.SearchPurchaseTypeDto;
import org.apatrios.api.dictionary.purchase_type.mapper.PurchaseTypeMapper;
import org.apatrios.model.dictoinary.PurchaseType;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.PurchaseTypeService;
import org.apatrios.service.dictionary.argument.SearchPurchaseTypeArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("dict/purchaseType")
public class PurchaseTypeController extends BaseDictionaryController<PurchaseType, SearchPurchaseTypeArgument, SearchPurchaseTypeDto, PurchaseTypeDto> {

    private final PurchaseTypeMapper mapper;
    private final PurchaseTypeService purchaseTypeService;

    @Override
    protected BaseDictionaryService<PurchaseType, SearchPurchaseTypeArgument, ?> getService() {
        return purchaseTypeService;
    }

    @Override
    protected BaseDictionaryMapper<PurchaseType, PurchaseTypeDto, SearchPurchaseTypeDto, SearchPurchaseTypeArgument> getMapper() {
        return mapper;
    }
}
