package org.apatrios.service.dictionary;

import lombok.RequiredArgsConstructor;
import org.apatrios.model.dictoinary.PaymentType;
import org.apatrios.model.dictoinary.QPaymentType;
import org.apatrios.repository.dictionary.BaseDictionaryRepository;
import org.apatrios.repository.dictionary.PaymentTypeRepository;
import org.apatrios.service.dictionary.argument.SearchPaymentTypeArgument;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentTypeService extends BaseDictionaryService<PaymentType, SearchPaymentTypeArgument, QPaymentType> {

    private final PaymentTypeRepository repository;

    @Override
    protected BaseDictionaryRepository<PaymentType> getRepository() {
        return repository;
    }

    @Override
    protected QPaymentType getQRoot() {
        return QPaymentType.paymentType;
    }
}
