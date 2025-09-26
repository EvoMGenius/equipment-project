package org.apatrios.controller.dictionary.dto;

import lombok.*;
import org.apatrios.model.dictoinary.EntityStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DictionaryDto {
    private UUID id;
    private String name;
    private EntityStatus status;
    private LocalDateTime createDate;
}
