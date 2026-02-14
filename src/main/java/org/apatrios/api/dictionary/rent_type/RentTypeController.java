package org.apatrios.api.dictionary.rent_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.rent_type.dto.RentTypeDto;
import org.apatrios.api.dictionary.rent_type.dto.SearchRentTypeDto;
import org.apatrios.api.dictionary.rent_type.mapper.RentTypeMapper;
import org.apatrios.model.dictoinary.RentType;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.RentTypeService;
import org.apatrios.service.dictionary.argument.SearchRentTypeArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("dict/rentType")
public class RentTypeController extends BaseDictionaryController<RentType, SearchRentTypeArgument, SearchRentTypeDto, RentTypeDto> {

    private final RentTypeService service;
    private final RentTypeMapper mapper;

    @Override
    protected BaseDictionaryService<RentType, SearchRentTypeArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<RentType, RentTypeDto, SearchRentTypeDto, SearchRentTypeArgument> getMapper() {
        return mapper;
    }
}
