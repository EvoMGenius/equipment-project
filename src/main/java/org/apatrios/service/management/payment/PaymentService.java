package org.apatrios.service.management.payment;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.Payment;
import org.apatrios.model.management.QPayment;
import org.apatrios.repository.managment.PaymentRepository;
import org.apatrios.service.management.payment.argument.CreatePaymentArgument;
import org.apatrios.service.management.payment.argument.SearchPaymentArgument;
import org.apatrios.service.management.payment.argument.UpdatePaymentArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final QPayment qPayment = QPayment.payment;

    @Transactional
    public Payment create(@NonNull CreatePaymentArgument argument) {
        return repository.save(Payment.builder()
                                      .paymentType(argument.getPaymentType())
                                      .status(argument.getStatus())
                                      .amount(argument.getAmount())
                                      .entityType(argument.getEntityType())
                                      .currency(argument.getCurrency())
                                      .build());
    }

    @Transactional
    public Payment update(@NonNull UUID id, @NonNull UpdatePaymentArgument argument) {
        Payment payment = getExisting(id);

        Optional.ofNullable(argument.getAmount()).ifPresent(payment::setAmount);
        Optional.ofNullable(argument.getStatus()).ifPresent(payment::setStatus);
        Optional.ofNullable(argument.getPaymentType()).ifPresent(payment::setPaymentType);
        Optional.ofNullable(argument.getEntityType()).ifPresent(payment::setEntityType);
        Optional.ofNullable(argument.getCurrency()).ifPresent(payment::setCurrency);
        Optional.ofNullable(argument.getPaymentUrl()).ifPresent(payment::setPaymentUrl);

        return repository.save(payment);
    }

    @Transactional(readOnly = true)
    public Page<Payment> page(@NonNull SearchPaymentArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchPaymentArgument argument) {
        return QPredicates.builder()
                          .add(argument.getPaymentTypeId(), qPayment.paymentType.id::eq)
                          .add(argument.getStatusId(), qPayment.status.id::eq)
                          .add(argument.getCurrency(), qPayment.currency::containsIgnoreCase)
                          .add(argument.getAmount(), qPayment.amount::eq)
                          .add(argument.getEntityTypeId(), qPayment.entityType.id::eq)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Payment getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Payment.notFound"));
    }
}
