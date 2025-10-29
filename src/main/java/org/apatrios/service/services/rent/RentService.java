package org.apatrios.service.services.rent;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.Rent;
import org.apatrios.model.services.QRent;
import org.apatrios.model.services.RentStatus;
import org.apatrios.repository.services.RentRepository;
import org.apatrios.service.services.rent.argument.CreateRentArgument;
import org.apatrios.service.services.rent.argument.UpdateRentArgument;
import org.apatrios.service.services.rent.argument.SearchRentArgument;
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
public class RentService {

    private final RentRepository repository;
    private final QRent qRent = QRent.rent;

    @Transactional
    public Rent create(@NonNull CreateRentArgument argument) {
        return repository.save(Rent.builder()
                                   .staff(argument.getStaff())
                                   .rentStart(argument.getRentStart())
                                   .rentEnd(argument.getRentEnd())
                                   .rentStatus(RentStatus.NEW)
                                   .client(argument.getClient())
                                   .payment(argument.getPayment())
                                   .comment(argument.getComment())
                                   .parentRent(argument.getParentRent())
                                   .parentRequest(argument.getParentRequest())
                                   .createDate(LocalDateTime.now())
                                   .updateDate(LocalDateTime.now())
                                   .tariff(argument.getTariff())
                                   .partner(argument.getPartner())
                                   .franchiseeIds(argument.getFranchiseeIds())
                                   .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Rent update(@NonNull UUID id, @NonNull UpdateRentArgument argument) {
        Rent existing = getExisting(id);

        existing.setStaff(argument.getStaff());
        existing.setRentStart(argument.getRentStart());
        existing.setRentEnd(argument.getRentEnd());
        existing.setRentStatus(argument.getRentStatus());
        existing.setClient(argument.getClient());
        existing.setPayment(argument.getPayment());
        existing.setComment(argument.getComment());
        existing.setParentRent(argument.getParentRent());
        existing.setParentRequest(argument.getParentRequest());
        existing.setUpdateDate(LocalDateTime.now());
        existing.setPartner(argument.getPartner());
        existing.setTariff(argument.getTariff());
        existing.setFranchiseeIds(argument.getFranchiseeIds());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Rent> list(@NonNull SearchRentArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Rent> page(@NonNull SearchRentArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchRentArgument argument) {
        return QPredicates.builder()
                          .add(argument.getStaffId(), qRent.staff.id::eq)
                          .add(argument.getClientId(), qRent.client.id::eq)
                          .add(argument.getRentStatus(), qRent.rentStatus::eq)
                          .add(argument.getPaymentId(), qRent.payment.id::eq)
                          .add(argument.getParentRentId(), qRent.parentRent.id::eq)
                          .add(argument.getParentRequestId(), qRent.parentRequest.id::eq)
                          .add(argument.isDeleted(), qRent.isDeleted::eq)
                          .add(argument.getCreateDateFrom(), qRent.createDate::goe)
                          .add(argument.getUpdateDateFrom(), qRent.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qRent.updateDate::loe)
                          .add(argument.getCreateDateTo(), qRent.createDate::loe)
                          .add(argument.getPartnerId(), qRent.partner.id::eq)
                          .add(argument.getTariffId(), qRent.tariff.id::eq)
                          .add(argument.getFranchiseeIds(), qRent.franchiseeIds.any()::in)
                          .addAnyString(argument.getSearchString(),
                                        qRent.comment::containsIgnoreCase,
                                        qRent.partner.name::containsIgnoreCase,
                                        qRent.client.clientProfile.name::containsIgnoreCase,
                                        qRent.rentStatus.stringValue()::containsIgnoreCase,
                                        qRent.staff.staffProfile.name::containsIgnoreCase,
                                        qRent.tariff.name::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Rent getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Rent.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        Rent existing = getExisting(id);
        existing.setDeleted(true);
        repository.save(existing);
    }
}
