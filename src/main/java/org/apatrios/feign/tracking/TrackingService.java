package org.apatrios.feign.tracking;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@FeignClient(name = "tracking-service", url = "${app.host}")
public interface TrackingService {

    @PostMapping("/api/v1/equip/bike/{id}/unblock")
    void unblock(@PathVariable("id") UUID id);

    @PostMapping("/api/v1/equip/bike/{id}/block")
    void block(@PathVariable("id") UUID id);

    @PostMapping("/api/v1/equip/bike/{id}/alarm_on")
    void alarmOn(@PathVariable("id") UUID id);

    @PostMapping("/api/v1/equip/bike/{id}/alarm_off")
    void alarmOff(@PathVariable("id") UUID id);

    @PostMapping("/api/v1/equip/bike/{id}/headlights_on")
    void headlightsOn(@PathVariable("id") UUID id);

    @PostMapping("/api/v1/equip/bike/{id}/headlights_off")
    void headlightsOff(@PathVariable("id") UUID id);

    @PostMapping("/api/v1/equip/bike/{id}/honk")
    void honk(@PathVariable("id") UUID id);
}
