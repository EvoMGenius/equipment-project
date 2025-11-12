package org.apatrios.feign;

import org.apatrios.feign.dto.CreateYookassaPaymentDto;
import org.apatrios.feign.dto.CreateYookassaRefundDto;
import org.apatrios.feign.dto.YookassaPaymentDto;
import org.apatrios.feign.interceptor.YookassaInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "yookassa-client",  url = "${yookassa.url}", configuration = YookassaInterceptor.class)
public interface YookassaFeign {

    @PostMapping("/payments")
    YookassaPaymentDto createYookassaPayment(@RequestHeader("Idempotence-Key") String idempotenceKey, @RequestBody CreateYookassaPaymentDto dto);

    @PostMapping("/refunds")
    YookassaPaymentDto createYookassaRefund(@RequestHeader("Idempotence-Key") String idempotenceKey, @RequestBody CreateYookassaRefundDto dto);
}
