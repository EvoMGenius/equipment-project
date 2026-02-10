package org.apatrios.api.services.recruit.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.recruit.create.CreateRecruitActionArgument;
import org.apatrios.api.services.recruit.internal.dto.CreateRecruitDto;
import org.apatrios.api.services.recruit.internal.dto.RecruitDto;
import org.apatrios.api.services.recruit.internal.dto.SearchRecruitDto;
import org.apatrios.model.services.Recruit;
import org.apatrios.service.services.recruit.RecruitService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.recruit.internal.mapper.RecruitMapper.RECRUIT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service/recruit")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RecruitController {

    RecruitService service;
    Action<CreateRecruitActionArgument, Recruit> createRecruitAction;

    @PostMapping
    public RecruitDto create(@Valid @RequestBody CreateRecruitDto dto) {
        return RECRUIT_MAPPER.toDto(createRecruitAction.execute(RECRUIT_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public RecruitDto get(@PathVariable UUID id) {
        return RECRUIT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public List<RecruitDto> list(SearchRecruitDto dto, Sort sort) {
        return service.list(RECRUIT_MAPPER.toSearchArgument(dto), sort)
                      .stream()
                      .map(RECRUIT_MAPPER::toDto)
                      .toList();
    }
}
