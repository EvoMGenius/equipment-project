package org.apatrios.api.management.payment.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.VoidAction;
import org.apatrios.action.management.payment.create.CreatePaymentActionArgument;
import org.apatrios.action.management.payment.refund.argument.CreateYookassaRefundActionArgument;
import org.apatrios.action.management.payment.update.UpdatePaymentActionArgument;
import org.apatrios.api.management.payment.internal.dto.*;
import org.apatrios.model.management.Payment;
import org.apatrios.service.management.payment.PaymentService;
import org.apatrios.service.management.payment.argument.SearchPaymentArgument;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.management.payment.internal.mapper.PaymentMapper.PAYMENT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/payment")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PaymentController {

    PaymentService service;
    Action<CreatePaymentActionArgument, Payment> createPaymentAction;
    Action<UpdatePaymentActionArgument, Payment> updatePaymentAction;
    VoidAction<CreateYookassaRefundActionArgument> createYookassaRefundAction;

    @PostMapping("create")
    public PaymentDto create(@Valid @RequestBody CreatePaymentDto dto) {
        return PAYMENT_MAPPER.toDto(createPaymentAction.execute(PAYMENT_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public PaymentDto update(@Valid @RequestBody UpdatePaymentDto dto) {
        return PAYMENT_MAPPER.toDto(updatePaymentAction.execute(PAYMENT_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("{id}")
    public PaymentDto get(@PathVariable UUID id) {
        return PAYMENT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("list")
    public List<PaymentDto> list(SearchPaymentDto dto, Sort sort) {
        SearchPaymentArgument argument = PAYMENT_MAPPER.toSearchArgument(dto);

        return service.list(argument, sort)
                      .stream()
                      .map(PAYMENT_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<PaymentDto> page(SearchPaymentDto dto, Pageable pageable) {
        SearchPaymentArgument argument = PAYMENT_MAPPER.toSearchArgument(dto);

        Page<PaymentDto> dtoPage = service.page(argument, pageable)
                                             .map(PAYMENT_MAPPER::toDto);

        return CollectionDto.of(dtoPage);
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @PostMapping("refund")
    public void refund(@RequestBody CreateYookassaRefundDto dto) {
        createYookassaRefundAction.execute(PAYMENT_MAPPER.toCreateRefundArgument(dto));
    }
}
