package org.apatrios.api.services.feedback.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.feedback.create.CreateFeedbackActionArgument;
import org.apatrios.api.services.feedback.internal.dto.CreateFeedbackDto;
import org.apatrios.api.services.feedback.internal.dto.FeedbackDto;
import org.apatrios.api.services.feedback.internal.dto.SearchFeedbackDto;
import org.apatrios.model.services.Feedback;
import org.apatrios.service.services.feedback.FeedbackService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.feedback.internal.mapper.FeedbackMapper.FEEDBACK_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service/feedback")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FeedbackController {

    FeedbackService service;
    Action<CreateFeedbackActionArgument, Feedback> createFeedbackAction;

    @PostMapping
    public FeedbackDto create(@Valid @RequestBody CreateFeedbackDto dto) {
        return FEEDBACK_MAPPER.toDto(createFeedbackAction.execute(FEEDBACK_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public FeedbackDto get(@PathVariable UUID id) {
        return FEEDBACK_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public List<FeedbackDto> list(SearchFeedbackDto dto, Sort sort) {
        return service.list(FEEDBACK_MAPPER.toSearchArgument(dto), sort)
                      .stream()
                      .map(FEEDBACK_MAPPER::toDto)
                      .toList();
    }
}
