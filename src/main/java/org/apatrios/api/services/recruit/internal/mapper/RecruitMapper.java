package org.apatrios.api.services.recruit.internal.mapper;

import org.apatrios.action.services.recruit.create.CreateRecruitActionArgument;
import org.apatrios.api.services.recruit.internal.dto.CreateRecruitDto;
import org.apatrios.api.services.recruit.internal.dto.RecruitDto;
import org.apatrios.api.services.recruit.internal.dto.SearchRecruitDto;
import org.apatrios.model.services.Recruit;
import org.apatrios.service.services.recruit.argument.SearchRecruitArgument;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecruitMapper {
    RecruitMapper RECRUIT_MAPPER = Mappers.getMapper(RecruitMapper.class);

    RecruitDto toDto(Recruit recruit);
    CreateRecruitActionArgument toCreateArgument(CreateRecruitDto dto);
    SearchRecruitArgument toSearchArgument(SearchRecruitDto dto);
}
