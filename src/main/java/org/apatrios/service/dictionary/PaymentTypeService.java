package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.model.dictoinary.QBaseDictionary;
import org.apatrios.model.dictoinary.QPaymentType;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.PaymentTypeRepository;
import org.apatrios.service.dictionary.argument.BaseDictionarySearchArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentTypeService extends BaseDictionaryService<PaymentType, BaseDictionarySearchArgument, QBaseDictionary> {

    private final PaymentTypeRepository repository;

    @Override
    protected BaseDictionaryRepository<PaymentType> getRepository() {
        return this.repository;
    }

    @Override
    protected QBaseDictionary getQRoot() {
        return QPaymentType.paymentType._super;
    }
}
