package org.apatrios.service.management.payment;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.Payment;
import org.apatrios.model.management.PaymentStatus;
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
                                      .paymentType(argument.paymentType())
                                      .status(PaymentStatus.CREATED)
                                      .amount(argument.amount())
                                      .entityType(argument.entityType())
                                      .entityId(argument.entityId())
                                      .currency(argument.currency())
                                      .company(argument.company())
                                      .dateOfDemand(argument.dateOfDemand())
                                      .build());
    }

    @Transactional
    public Payment update(@NonNull UUID id, @NonNull UpdatePaymentArgument argument) {
        Payment payment = getExisting(id);

        Optional.ofNullable(argument.amount()).ifPresent(payment::setAmount);
        Optional.ofNullable(argument.status()).ifPresent(payment::setStatus);
        Optional.ofNullable(argument.paymentType()).ifPresent(payment::setPaymentType);
        Optional.ofNullable(argument.entityType()).ifPresent(payment::setEntityType);
        Optional.ofNullable(argument.currency()).ifPresent(payment::setCurrency);
        Optional.ofNullable(argument.metadata()).ifPresent(payment::setMetadata);
        Optional.ofNullable(argument.status()).ifPresent(payment::setStatus);
        Optional.ofNullable(argument.dateOfDemand()).ifPresent(payment::setDateOfDemand);
        Optional.ofNullable(argument.company()).ifPresent(payment::setCompany);

        return repository.save(payment);
    }

    @Transactional(readOnly = true)
    public Page<Payment> page(@NonNull SearchPaymentArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchPaymentArgument argument) {
        return QPredicates.builder()
                          .add(argument.companyId(), qPayment.company.id::eq)
                          .add(argument.paymentTypeId(), qPayment.paymentType.id::eq)
                          .add(argument.status(), qPayment.status::eq)
                          .add(argument.currency(), qPayment.currency::equalsIgnoreCase)
                          .add(argument.amountFrom(), qPayment.amount::goe)
                          .add(argument.amountTo(), qPayment.amount::loe)
                          .add(argument.entityId(), qPayment.entityId::eq)
                          .add(argument.entityType(), qPayment.entityType::containsIgnoreCase)
                          .add(argument.dateOfDemandFrom(), qPayment.dateOfDemand::goe)
                          .add(argument.dateOfDemandTo(), qPayment.dateOfDemand::loe)
                          .add(argument.createDateFrom(), qPayment.createDate::goe)
                          .add(argument.createDateTo(), qPayment.createDate::loe)
                          .add(argument.updateDateFrom(), qPayment.updateDate::goe)
                          .add(argument.updateDateTo(), qPayment.updateDate::loe)
                          .add(argument.isDeleted(), qPayment.isDeleted::eq)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Payment getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Payment.notFound"));
    }
}
