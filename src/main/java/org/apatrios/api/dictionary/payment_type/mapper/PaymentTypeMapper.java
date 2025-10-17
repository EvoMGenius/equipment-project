package org.apatrios.api.dictionary.payment_type.mapper;

import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.payment_type.dto.PaymentTypeDto;
import org.apatrios.api.dictionary.payment_type.dto.SearchPaymentTypeDto;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentTypeMapper extends BaseDictionaryMapper<PaymentType, PaymentTypeDto, SearchPaymentTypeDto, BaseDictionarySearchArgument> {
}
