package org.apatrios.service.services.client;

import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.services.Client;
import org.apatrios.model.services.QClient;
import org.apatrios.repository.services.ClientRepository;
import org.apatrios.service.services.client.argument.CreateClientArgument;
import org.apatrios.service.services.client.argument.SearchClientArgument;
import org.apatrios.service.services.client.argument.UpdateClientArgument;
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
public class ClientService {

    private final ClientRepository repository;
    private final QClient qClient = QClient.client;

    @Transactional
    public Client create(@NonNull CreateClientArgument argument) {
        return repository.save(Client.builder()
                                     .clientProfile(argument.getClientProfile())
                                     .franchisee(argument.getFranchisee())
                                     .createDate(LocalDateTime.now())
                                     .updateDate(LocalDateTime.now())
                                     .build());
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Client update(@NonNull UUID id, @NonNull UpdateClientArgument argument) {
        Client existing = getExisting(id);

        existing.setClientProfile(argument.getClientProfile());
        existing.setFranchisee(argument.getFranchisee());
        existing.setUpdateDate(LocalDateTime.now());

        return repository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Client> list(@NonNull SearchClientArgument argument, Sort sort) {
        Predicate predicate = buildPredicate(argument);
        return Lists.newArrayList(repository.findAll(predicate, sort));
    }

    @Transactional(readOnly = true)
    public Page<Client> page(@NonNull SearchClientArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchClientArgument argument) {
        return QPredicates.builder()
                          .add(argument.getPhone(), qClient.clientProfile.phone::containsIgnoreCase)
                          .add(argument.getSurname(), qClient.clientProfile.surname::containsIgnoreCase)
                          .add(argument.getName(), qClient.clientProfile.name::containsIgnoreCase)
                          .add(argument.getFranchiseeId(), qClient.franchisee.id::eq)
                          .add(argument.isDeleted(), qClient.isDeleted::eq)
                          .add(argument.getCreateDateFrom(), qClient.createDate::goe)
                          .add(argument.getCreateDateTo(), qClient.createDate::loe)
                          .add(argument.getUpdateDateFrom(), qClient.updateDate::goe)
                          .add(argument.getUpdateDateTo(), qClient.updateDate::loe)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Client getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Client.notFound"));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(@NonNull UUID id) {
        Client existing = getExisting(id);
        existing.setDeleted(true);
        repository.save(existing);
    }
}
