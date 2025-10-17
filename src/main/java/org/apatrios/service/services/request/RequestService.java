package org.apatrios.service.services.request;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.Request;
import org.apatrios.model.services.QRequest;
import org.apatrios.model.services.RequestStatus;
import org.apatrios.repository.services.RequestRepository;
import org.apatrios.service.services.request.argument.CreateRequestArgument;
import org.apatrios.service.services.request.argument.UpdateRequestArgument;
import org.apatrios.service.services.request.argument.SearchRequestArgument;
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
public class RequestService {

    private final RequestRepository repository;
    private final QRequest qRequest = QRequest.request;

    @Transactional
    public Request create(@NonNull CreateRequestArgument argument) {
        return repository.save(Request.builder()
                                      .requestProfile(argument.getRequestProfile())
                                      .serviceType(argument.getServiceType())
                                      .modelBike(argument.getModelBike())
                                      .note(argument.getNote())
                                      .client(argument.getClient())
                                      .status(RequestStatus.NEW)
                                      .createDate(LocalDateTime.now())
                                      .updateDate(LocalDateTime.now())
                                      .rejectionReason(argument.getRejectionReason())
                                      .rejectNote(argument.getRejectNote())
                                      .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Request update(@NonNull UUID id, @NonNull UpdateRequestArgument argument) {
        Request existing = getExisting(id);

        existing.setRequestProfile(argument.getRequestProfile());
        existing.setServiceType(argument.getServiceType());
        existing.setModelBike(argument.getModelBike());
        existing.setNote(argument.getNote());
        existing.setClient(argument.getClient());
        existing.setStatus(argument.getStatus());
        existing.setUpdateDate(LocalDateTime.now());
        existing.setRejectionReason(argument.getRejectionReason());
        existing.setRejectNote(argument.getRejectNote());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Request> list(@NonNull SearchRequestArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Request> page(@NonNull SearchRequestArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchRequestArgument argument) {
        return QPredicates.builder()
                          .add(argument.getServiceTypeId(), qRequest.serviceType.id::eq)
                          .add(argument.getModelBikeId(), qRequest.modelBike.id::eq)
                          .add(argument.getClientId(), qRequest.client.id::eq)
                          .add(argument.getStatus(), qRequest.status::eq)
                          .add(argument.getNote(), qRequest.note::containsIgnoreCase)
                          .add(argument.getPhone(), qRequest.requestProfile.phone::containsIgnoreCase)
                          .add(argument.getSurname(), qRequest.requestProfile.surname::containsIgnoreCase)
                          .add(argument.getName(), qRequest.requestProfile.name::containsIgnoreCase)
                          .add(argument.isDeleted(), qRequest.isDeleted::eq)
                          .add(argument.getCreateDateFrom(), qRequest.createDate::goe)
                          .add(argument.getCreateDateTo(), qRequest.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qRequest.updateDate::goe)
                          .add(argument.getCreateDateTo(), qRequest.updateDate::loe)
                          .add(argument.getRejectNote(), qRequest.rejectNote::containsIgnoreCase)
                          .add(argument.getRejectionReasonId(), qRequest.rejectionReason.id::eq)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Request getExisting(@NonNull UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Request.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        Request existing = getExisting(id);
        existing.setDeleted(true);
        repository.save(existing);
    }
}
