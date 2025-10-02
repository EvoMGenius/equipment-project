package org.apatrios.api.dictionary.payment_type;

import lombok.RequiredArgsConstructor;
import org.apatrios.api.dictionary.BaseDictionaryController;
import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;
import org.apatrios.api.dictionary.common.dto.BaseDictionarySearchDto;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.service.dictionary.PaymentTypeService;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("payment-type")
public class PaymentTypeController extends BaseDictionaryController<PaymentType, BaseDictionarySearchArgument, BaseDictionarySearchDto, BaseDictionaryDto> {

    private final PaymentTypeService service;

    @Override
    protected SimpleDictionaryService<PaymentType> getService() {
        return this.service;
    }
}
