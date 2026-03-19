package org.apatrios.api.equipment.bike;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.VoidAction;
import org.apatrios.action.equipment.bike.create.argument.CreateBikeActionArgument;
import org.apatrios.action.equipment.bike.tracking.argument.BikeTrackingActionArgument;
import org.apatrios.api.equipment.bike.dto.BikeDto;
import org.apatrios.api.equipment.bike.dto.CreateBikeDto;
import org.apatrios.api.equipment.bike.dto.SearchBikeDto;
import org.apatrios.feign.tracking.TrackingService;
import org.apatrios.model.equipment.Bike;
import org.apatrios.service.equipment.bike.BikeService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.apatrios.api.equipment.bike.mapper.BikeMapper.BIKE_MAPPER;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/equip/bike")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BikeController {

    Action<CreateBikeActionArgument, Bike> createBikeAction;
    VoidAction<BikeTrackingActionArgument> bikeTrackingAction;
    BikeService service;

    @PostMapping("/{id}/unblock")
    public void unblock(@PathVariable UUID id) {
        bikeTrackingAction.execute(BikeTrackingActionArgument.builder()
                                                             .bikeId(id)
                                                             .operation(TrackingService::unblock)
                                                             .build());
    }

    @PostMapping("/{id}/block")
    public void block(@PathVariable UUID id) {
        bikeTrackingAction.execute(BikeTrackingActionArgument.builder()
                                                             .bikeId(id)
                                                             .operation(TrackingService::block)
                                                             .build());
    }

    @PostMapping("/{id}/alarm_on")
    public void alarmOn(@PathVariable UUID id) {
        bikeTrackingAction.execute(BikeTrackingActionArgument.builder()
                                                             .bikeId(id)
                                                             .operation(TrackingService::alarmOn)
                                                             .build());
    }

    @PostMapping("/{id}/alarm_off")
    public void alarmOff(@PathVariable UUID id) {
        bikeTrackingAction.execute(BikeTrackingActionArgument.builder()
                                                             .bikeId(id)
                                                             .operation(TrackingService::alarmOff)
                                                             .build());
    }

    @PostMapping("/{id}/headlights_on")
    public void headlightsOn(@PathVariable UUID id) {
        bikeTrackingAction.execute(BikeTrackingActionArgument.builder()
                                                             .bikeId(id)
                                                             .operation(TrackingService::headlightsOn)
                                                             .build());
    }

    @PostMapping("/{id}/headlights_off")
    public void headlightsOff(@PathVariable UUID id) {
        bikeTrackingAction.execute(BikeTrackingActionArgument.builder()
                                                             .bikeId(id)
                                                             .operation(TrackingService::headlightsOff)
                                                             .build());
    }

    @PostMapping("/{id}/honk")
    public void honk(@PathVariable UUID id) {
        bikeTrackingAction.execute(BikeTrackingActionArgument.builder()
                                                             .bikeId(id)
                                                             .operation(TrackingService::honk)
                                                             .build());
    }

    @PostMapping
    public BikeDto create(@Valid @RequestBody CreateBikeDto dto) {
        return BIKE_MAPPER.toDto(createBikeAction.execute(BIKE_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public BikeDto get(@PathVariable UUID id) {
        return BIKE_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public CollectionDto<BikeDto> page(SearchBikeDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(BIKE_MAPPER.toSearchArgument(dto), pageable)
                                       .map(BIKE_MAPPER::toDto));
    }
}
