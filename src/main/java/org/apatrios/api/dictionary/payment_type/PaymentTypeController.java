package org.apatrios.api.dictionary.payment_type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.mapper.BaseDictionaryMapper;
import org.apatrios.api.dictionary.payment_type.dto.PaymentTypeDto;
import org.apatrios.api.dictionary.payment_type.dto.SearchPaymentTypeDto;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.service.dictionary.BaseDictionaryService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("payment-type")
public class PaymentTypeController extends BaseDictionaryController<PaymentType, BaseDictionarySearchArgument, SearchPaymentTypeDto, PaymentTypeDto> {

    @Getter
    private final BaseDictionaryService<PaymentType, BaseDictionarySearchArgument, ?> service;
    @Getter
    private final BaseDictionaryMapper<PaymentType, PaymentTypeDto, SearchPaymentTypeDto, BaseDictionarySearchArgument> mapper;

}
