package org.apatrios.service.management.payment;

import com.google.common.collect.Lists;
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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final QPayment qPayment = QPayment.payment;

    @Transactional
    public Payment create(@NonNull CreatePaymentArgument argument) {
        return repository.save(Payment.builder()
                                      .amount(argument.getAmount())
                                      .currency(argument.getCurrency())
                                      .paymentType(argument.getPaymentType())
                                      .status(PaymentStatus.IN_PROGRESS)
                                      .entityId(argument.getEntityId())
                                      .entityType(argument.getEntityType())
                                      .createDate(LocalDateTime.now())
                                      .updateDate(LocalDateTime.now())
                                      .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Payment update(@NonNull UUID id, @NonNull UpdatePaymentArgument argument) {
        Payment existing = getExisting(id);

        existing.setAmount(argument.getAmount());
        existing.setCurrency(argument.getCurrency());
        existing.setPaymentType(argument.getPaymentType());
        existing.setStatus(argument.getStatus());
        existing.setEntityId(argument.getEntityId());
        existing.setEntityType(argument.getEntityType());
        existing.setUpdateDate(LocalDateTime.now());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Payment> list(@NonNull SearchPaymentArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Payment> page(@NonNull SearchPaymentArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchPaymentArgument argument) {
        return QPredicates.builder()
                          .add(argument.getPaymentTypeId(), qPayment.paymentType.id::eq)
                          .add(argument.getStatus(), qPayment.status::eq)
                          .add(argument.getEntityId(), qPayment.entityId::eq)
                          .add(argument.getEntityType(), qPayment.entityType::containsIgnoreCase)
                          .add(argument.getCurrency(), qPayment.currency::eq)
                          .add(argument.getAmount(), qPayment.amount::eq)
                          .add(argument.getCreateDateFrom(), qPayment.createDate::goe)
                          .add(argument.getCreateDateTo(), qPayment.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qPayment.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qPayment.updateDate::loe)
                          .add(argument.isDeleted(), qPayment.isDeleted::eq)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Payment getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Payment.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        Payment existing = getExisting(id);
        existing.setDeleted(true);
        repository.save(existing);
    }
}
