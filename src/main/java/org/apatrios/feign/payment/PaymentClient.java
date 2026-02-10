package org.apatrios.feign.payment;

import org.apatrios.feign.payment.dto.CreateYookassaPaymentDto;
import org.apatrios.feign.payment.dto.CreateYookassaRefundDto;
import org.apatrios.feign.payment.dto.YookassaPaymentDto;
import org.apatrios.feign.payment.interceptor.YookassaInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "payment-client",  url = "${yookassa.url}", configuration = YookassaInterceptor.class)
public interface PaymentClient {

    @PostMapping("/payments")
    YookassaPaymentDto createYookassaPayment(@RequestHeader("Idempotence-Key") String idempotenceKey, @RequestBody CreateYookassaPaymentDto dto);

    @PostMapping("/refunds")
    void createYookassaRefund(@RequestHeader("Idempotence-Key") String idempotenceKey, @RequestBody CreateYookassaRefundDto dto);
}
