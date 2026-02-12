package org.apatrios.api.management.payment.create;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.management.payment.create.CreatePaymentActionArgument;
import org.apatrios.api.management.payment.create.dto.*;
import org.apatrios.model.management.Payment;
import org.apatrios.service.management.payment.PaymentService;
import org.apatrios.service.management.payment.argument.SearchPaymentArgument;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.management.payment.create.mapper.PaymentMapper.PAYMENT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/management/payment")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PaymentController {

    PaymentService service;
    Action<CreatePaymentActionArgument, Payment> createPaymentAction;

    @PostMapping("payoff")
    public PaymentDto create(@Valid @RequestBody CreatePaymentDto dto) {
        return PAYMENT_MAPPER.toDto(createPaymentAction.execute(PAYMENT_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public PaymentDto get(@PathVariable UUID id) {
        return PAYMENT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public List<PaymentDto> list(SearchPaymentDto dto, Sort sort) {
        SearchPaymentArgument argument = PAYMENT_MAPPER.toSearchArgument(dto);

        return service.list(argument, sort)
                      .stream()
                      .map(PAYMENT_MAPPER::toDto)
                      .toList();
    }
}
