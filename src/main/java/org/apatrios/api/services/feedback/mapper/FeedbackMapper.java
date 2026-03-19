package org.apatrios.api.services.feedback.mapper;

import org.apatrios.api.services.feedback.dto.CreateFeedbackDto;
import org.apatrios.api.services.feedback.dto.FeedbackDto;
import org.apatrios.api.services.feedback.dto.SearchFeedbackDto;
import org.apatrios.model.services.Feedback;
import org.apatrios.service.services.feedback.argument.CreateFeedbackArgument;
import org.apatrios.service.services.feedback.argument.SearchFeedbackArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FeedbackMapper {
    FeedbackMapper FEEDBACK_MAPPER = Mappers.getMapper(FeedbackMapper.class);

    FeedbackDto toDto(Feedback feedback);
    CreateFeedbackArgument toCreateArgument(CreateFeedbackDto dto);
    SearchFeedbackArgument toSearchArgument(SearchFeedbackDto dto);
}
