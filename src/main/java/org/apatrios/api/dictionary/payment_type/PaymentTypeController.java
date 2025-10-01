package org.apatrios.api.dictionary.payment_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.service.dictionary.PaymentTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("payment-type")
public class PaymentTypeController extends org.apatrios.api.dictionary.BaseDictionaryController<PaymentType, org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument, org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto, org.apatrios.api.dictionary.common.dto.BaseDictionaryDto> {

    private final PaymentTypeService service;

    @Override
    protected SimpleDictionaryService<PaymentType> getService() {
        return this.service;
    }
}
