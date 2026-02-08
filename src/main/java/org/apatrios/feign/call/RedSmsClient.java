package org.apatrios.feign.call;

import org.apatrios.feign.call.dto.RedSmsRequestDto;
import org.apatrios.feign.call.interceptor.RedSmsInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "redsms-client", url = "https://cp.redsms.ru/api", configuration = RedSmsInterceptor.class)
public interface RedSmsClient {

    @PostMapping("/message")
    void sendFlashCall(@RequestBody RedSmsRequestDto dto);
}
