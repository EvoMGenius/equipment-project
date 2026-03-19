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
import org.apatrios.service.dictionary.argument.SearchPaymentTypeArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("dict/paymentType")
public class PaymentTypeController extends BaseDictionaryController<PaymentType, SearchPaymentTypeArgument, SearchPaymentTypeDto, PaymentTypeDto> {

    private final PaymentTypeMapper mapper;
    private final PaymentTypeService paymentTypeService;

    @Override
    protected BaseDictionaryService<PaymentType, SearchPaymentTypeArgument, ?> getService() {
        return paymentTypeService;
    }

    @Override
    protected BaseDictionaryMapper<PaymentType, PaymentTypeDto, SearchPaymentTypeDto, SearchPaymentTypeArgument> getMapper() {
        return mapper;
    }
}
