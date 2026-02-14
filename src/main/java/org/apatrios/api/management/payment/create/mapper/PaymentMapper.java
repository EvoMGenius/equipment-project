package org.apatrios.api.management.payment.create.mapper;

import org.apatrios.action.management.payment.create.argument.CreatePaymentActionArgument;
import org.apatrios.api.management.payment.create.dto.*;
import org.apatrios.model.management.Payment;
import org.apatrios.service.management.payment.argument.SearchPaymentArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
    PaymentMapper PAYMENT_MAPPER = Mappers.getMapper(PaymentMapper.class);
    CreatePaymentActionArgument toCreateArgument(CreatePaymentDto dto);
    SearchPaymentArgument toSearchArgument(SearchPaymentDto dto);
    PaymentDto toDto(Payment payment);
}
