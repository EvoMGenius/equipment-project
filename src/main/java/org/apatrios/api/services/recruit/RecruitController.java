package org.apatrios.api.services.recruit;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.services.recruit.dto.CreateRecruitDto;
import org.apatrios.api.services.recruit.dto.RecruitDto;
import org.apatrios.api.services.recruit.dto.SearchRecruitDto;
import org.apatrios.service.services.recruit.RecruitService;
import org.apatrios.util.CollectionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.apatrios.api.services.recruit.mapper.RecruitMapper.RECRUIT_MAPPER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service/recruit")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RecruitController {

    RecruitService service;

    @PostMapping
    public RecruitDto create(@Valid @RequestBody CreateRecruitDto dto) {
        return RECRUIT_MAPPER.toDto(service.create(RECRUIT_MAPPER.toCreateArgument(dto)));
    }

    @GetMapping("{id}")
    public RecruitDto get(@PathVariable UUID id) {
        return RECRUIT_MAPPER.toDto(service.getExisting(id));
    }

    @GetMapping("search")
    public CollectionDto<RecruitDto> page(SearchRecruitDto dto, Pageable pageable) {
        return CollectionDto.of(service.page(RECRUIT_MAPPER.toSearchArgument(dto), pageable)
                                       .map(RECRUIT_MAPPER::toDto));
    }
}
