package org.apatrios.api.dictionary.payment_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.payment_type.dto.PaymentTypeDto;
import org.apatrios.api.dictionary.payment_type.dto.SearchPaymentTypeDto;
import org.apatrios.api.dictionary.payment_type.mapper.PaymentTypeMapper;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.PaymentTypeService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("payment-type")
public class PaymentTypeController extends BaseDictionaryController<PaymentType, BaseDictionarySearchArgument, SearchPaymentTypeDto, PaymentTypeDto> {

    private final PaymentTypeService service;

    private final PaymentTypeMapper mapper;

    @Override
    protected BaseDictionaryService<PaymentType, BaseDictionarySearchArgument, ?> getService() {
        return service;
    }

    @Override
    protected BaseDictionaryMapper<PaymentType, PaymentTypeDto, SearchPaymentTypeDto, BaseDictionarySearchArgument> getMapper() {
        return mapper;
    }

}
