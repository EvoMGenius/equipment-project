package org.apatrios.model.services;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.util.FileUrlSerializer;

import javax.persistence.Embeddable;

import static lombok.AccessLevel.PRIVATE;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Photo {
    String fileName;

    @JsonSerialize(using = FileUrlSerializer.class)
    String fileUrl;
}
