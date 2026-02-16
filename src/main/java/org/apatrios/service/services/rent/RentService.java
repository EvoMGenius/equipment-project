package org.apatrios.service.services.rent;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.Rent;
import org.apatrios.model.services.QRent;
import org.apatrios.model.services.RentStatus;
import org.apatrios.repository.services.RentRepository;
import org.apatrios.service.services.rent.argument.CreateRentArgument;
import org.apatrios.service.services.rent.argument.SearchRentArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RentService {

    private final RentRepository repository;
    private final QRent qRent = QRent.rent;

    @Transactional
    public Rent create(@NonNull CreateRentArgument argument) {
        return repository.save(Rent.builder()
                                   .bike(argument.getBike())
                                   .point(argument.getPoint())
                                   .currentDays(argument.getCurrentDays())
                                   .debts(argument.getDebts())
                                   .delay(argument.getDelay())
                                   .delayCost(argument.getDelayCost())
                                   .total(argument.getTotal())
                                   .documents(argument.getDocuments())
                                   .number(argument.getNumber())
                                   .outfits(argument.getOutfits())
                                   .startDate(LocalDateTime.now())
                                   .user(argument.getUser())
                                   .status(RentStatus.CREATED)
                                   .rentType(argument.getRentType())
                                   .payment(argument.getPayment())
                                   .build());
    }

    @Transactional(readOnly = true)
    public Page<Rent> page(@NonNull SearchRentArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    @Transactional
    public Rent closeRent(@NonNull UUID id) {
        Rent rent = getExisting(id);
        rent.setEndDate(LocalDateTime.now());
        rent.setStatus(RentStatus.CLOSED);
        return repository.save(rent);
    }

    private Predicate buildPredicate(SearchRentArgument argument) {
        return QPredicates.builder()
                          .add(argument.getNumber(), qRent.number::containsIgnoreCase)
                          .add(argument.getDelay(), qRent.delay::eq)
                          .add(argument.getOutfits(), qRent.outfits.any().id::in)
                          .add(argument.getDebtIds(), qRent.debts.any().id::in)
                          .add(argument.getCurrentDays(), qRent.currentDays::eq)
                          .add(argument.getDelayCost(), qRent.delayCost::eq)
                          .add(argument.getStatus(), qRent.status::eq)
                          .add(argument.getUserId(), qRent.user.id::eq)
                          .add(argument.getTotal(), qRent.total::eq)
                          .add(argument.getStartDate(), qRent.startDate::goe)
                          .add(argument.getEndDate(), qRent.endDate::loe)
                          .add(argument.getBikeId(), qRent.bike.id::eq)
                          .add(argument.getPointId(), qRent.point.id::eq)
                          .add(argument.getDelay(), qRent.delay::eq)
                          .add(argument.getRentTypeId(), qRent.rentType.id::eq)
                          .add(argument.getPaymentId(), qRent.payment.id::eq)
                          .addAnyString(argument.getSearchString(), qRent.number::containsIgnoreCase)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Rent getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Rent.notFound"));
    }
}
