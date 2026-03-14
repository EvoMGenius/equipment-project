package org.apatrios.service.management.company;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apatrios.exception.EntityNotFoundException;
import org.apatrios.model.management.Company;
import org.apatrios.model.management.CompanyStatus;
import org.apatrios.model.management.QCompany;
import org.apatrios.repository.managment.CompanyRepository;
import org.apatrios.service.management.company.argument.CreateCompanyArgument;
import org.apatrios.service.management.company.argument.SearchCompanyArgument;
import org.apatrios.util.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;
    private final QCompany qCompany = QCompany.company;

    @Transactional
    public Company create(@NonNull CreateCompanyArgument argument) {
        return repository.save(Company.builder()
                                      .name(argument.name())
                                      .inn(argument.inn())
                                      .address(argument.address())
                                      .phone(argument.phone())
                                      .email(argument.email())
                                      .status(CompanyStatus.CREATED)
                                      .build());
    }

    @Transactional(readOnly = true)
    public Page<Company> page(@NonNull SearchCompanyArgument argument, Pageable pageable) {
        Predicate predicate = buildPredicate(argument);
        return repository.findAll(predicate, pageable);
    }

    private Predicate buildPredicate(SearchCompanyArgument argument) {
        return QPredicates.builder()
                          .add(argument.name(), qCompany.name::containsIgnoreCase)
                          .add(argument.inn(), qCompany.inn::containsIgnoreCase)
                          .add(argument.address(), qCompany.address::containsIgnoreCase)
                          .add(argument.phone(), qCompany.phone::containsIgnoreCase)
                          .add(argument.email(), qCompany.email::containsIgnoreCase)
                          .add(argument.status(), qCompany.status::eq)
                          .add(argument.isDeleted(), qCompany.isDeleted::eq)
                          .add(argument.createDateFrom(), qCompany.createDate::goe)
                          .add(argument.createDateTo(), qCompany.createDate::loe)
                          .add(argument.updateDateFrom(), qCompany.updateDate::goe)
                          .add(argument.updateDateTo(), qCompany.updateDate::loe)
                          .buildAnd();
    }

    @Transactional(readOnly = true)
    public Company getExisting(@NonNull UUID id) {
        return repository.findById(id)
                         .orElseThrow(() -> new EntityNotFoundException("Company.notFound"));
    }
}