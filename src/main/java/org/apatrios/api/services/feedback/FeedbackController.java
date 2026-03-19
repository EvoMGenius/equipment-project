package org.apatrios.api.services.feedback;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.services.feedback.dto.CreateFeedbackDto;
import org.apatrios.api.services.feedback.dto.FeedbackDto;
import org.apatrios.api.services.feedback.dto.SearchFeedbackDto;
import org.apatrios.service.services.feedback.FeedbackService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.apatrios.api.services.feedback.mapper.FeedbackMapper.FEEDBACK_MAPPER;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/service/feedback")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FeedbackController {

    FeedbackService service;

    @PostMapping
    public FeedbackDto create(@Valid @RequestBody CreateFeedbackDto dto) {
        return FEEDBACK_MAPPER.toDto(service.create(FEEDBACK_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public FeedbackDto get(@PathVariable UUID id) {
        return FEEDBACK_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public CollectionDto<FeedbackDto> page(SearchFeedbackDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(FEEDBACK_MAPPER.toSearchArgument(dto), pageable)
                                       .map(FEEDBACK_MAPPER::toDto));
    }
}
