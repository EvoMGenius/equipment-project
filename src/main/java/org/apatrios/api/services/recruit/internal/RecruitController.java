package org.apatrios.api.services.recruit.internal;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.action.Action;
import org.apatrios.action.services.recruit.create.CreateRecruitActionArgument;
import org.apatrios.action.services.recruit.update.UpdateRecruitActionArgument;
import org.apatrios.api.services.recruit.internal.dto.CreateRecruitDto;
import org.apatrios.api.services.recruit.internal.dto.RecruitDto;
import org.apatrios.api.services.recruit.internal.dto.SearchRecruitDto;
import org.apatrios.api.services.recruit.internal.dto.UpdateRecruitDto;
import org.apatrios.model.services.Recruit;
import org.apatrios.service.services.recruit.RecruitService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.apatrios.api.services.recruit.internal.mapper.RecruitMapper.RECRUIT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("internal/recruit")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RecruitController {

    RecruitService service;
    Action<CreateRecruitActionArgument, Recruit> createRecruitAction;
    Action<UpdateRecruitActionArgument, Recruit> updateRecruitAction;

    @PostMapping("create")
    public RecruitDto create(@Valid @RequestBody CreateRecruitDto dto) {
        return RECRUIT_MAPPER.toDto(createRecruitAction.execute(RECRUIT_MAPPER.toCreateArgument(dto)));
    }

    @PutMapping("update")
    public RecruitDto update(@Valid @RequestBody UpdateRecruitDto dto) {
        return RECRUIT_MAPPER.toDto(updateRecruitAction.execute(RECRUIT_MAPPER.toUpdateArgument(dto)));
    }

    @GetMapping("{id}")
    public RecruitDto get(@PathVariable UUID id) {
        return RECRUIT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("list")
    public List<RecruitDto> list(SearchRecruitDto dto, Sort sort) {
        return service.list(RECRUIT_MAPPER.toSearchArgument(dto), sort)
                      .stream()
                      .map(RECRUIT_MAPPER::toDto)
                      .toList();
    }

    @GetMapping("page")
    public CollectionDto<RecruitDto> page(SearchRecruitDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(RECRUIT_MAPPER.toSearchArgument(dto), pageable)
                                       .map(RECRUIT_MAPPER::toDto));
    }

    @PostMapping("{id}/delete")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
