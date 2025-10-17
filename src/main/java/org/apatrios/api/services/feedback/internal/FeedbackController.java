package org.apatrios.api.services.feedback.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.feedback.create.CreateFeedbackActionArgument;
import org.apatrios.action.services.feedback.update.UpdateFeedbackActionArgument;
import org.apatrios.api.services.feedback.internal.dto.CreateFeedbackDto;
import org.apatrios.api.services.feedback.internal.dto.FeedbackDto;
import org.apatrios.api.services.feedback.internal.dto.SearchFeedbackDto;
import org.apatrios.api.services.feedback.internal.dto.UpdateFeedbackDto;
import org.apatrios.model.services.Feedback;
import org.apatrios.service.services.feedback.FeedbackService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.feedback.internal.mapper.FeedbackMapper.FEEDBACK_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/feedback")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FeedbackController {

    FeedbackService service;
    Action<CreateFeedbackActionArgument, Feedback> createFeedbackAction;
    Action<UpdateFeedbackActionArgument, Feedback> updateFeedbackAction;

    @PostMapping("create")
    public FeedbackDto create(@Valid @RequestBody CreateFeedbackDto dto) {
        return FEEDBACK_MAPPER.toDto(createFeedbackAction.execute(FEEDBACK_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public FeedbackDto update(@Valid @RequestBody UpdateFeedbackDto dto) {
        return FEEDBACK_MAPPER.toDto(updateFeedbackAction.execute(FEEDBACK_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("list")
    public List<FeedbackDto> list(SearchFeedbackDto dto, Sort sort) {
        return service.list(FEEDBACK_MAPPER.toSearchArgument(dto), sort)
                      .stream()
                      .map(FEEDBACK_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<FeedbackDto> page(SearchFeedbackDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(FEEDBACK_MAPPER.toSearchArgument(dto), pageable)
                                       .map(FEEDBACK_MAPPER::toDto));
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
