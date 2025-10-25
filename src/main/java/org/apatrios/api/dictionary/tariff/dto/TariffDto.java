package org.apatrios.api.dictionary.tariff.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apatrios.api.dictionary.common.dto.BaseDictionaryDto;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@EqualsAndHashCode(callSuper = true)
@Schema(description = "DTO тарифа")
public class TariffDto extends BaseDictionaryDto {
}
