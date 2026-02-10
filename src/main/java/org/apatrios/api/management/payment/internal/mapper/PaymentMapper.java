package org.apatrios.api.management.payment.internal.mapper;

import org.apatrios.action.management.payment.create.CreatePaymentActionArgument;
import org.apatrios.action.management.payment.refund.argument.CreateYookassaRefundActionArgument;
import org.apatrios.action.management.payment.update.UpdatePaymentActionArgument;
import org.apatrios.api.management.payment.internal.dto.*;
import org.apatrios.model.management.Payment;
import org.apatrios.service.management.payment.argument.SearchPaymentArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
    PaymentMapper PAYMENT_MAPPER = Mappers.getMapper(PaymentMapper.class);

    CreatePaymentActionArgument toCreateArgument(CreatePaymentDto dto);

    CreateYookassaRefundActionArgument toCreateRefundArgument(CreateYookassaRefundDto dto);

    UpdatePaymentActionArgument toUpdateArgument(UpdatePaymentDto dto);

    SearchPaymentArgument toSearchArgument(SearchPaymentDto dto);

    PaymentDto toDto(Payment payment);
}
