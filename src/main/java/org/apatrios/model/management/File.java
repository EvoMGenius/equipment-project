package org.apatrios.model.management;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.util.FileUrlSerializer;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static lombok.AccessLevel.PRIVATE;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class File {
    @Column(nullable = false)
    String type;

    @Column(nullable = false)
    @JsonSerialize(using = FileUrlSerializer.class)
    String url;

    @Column(nullable = false)
    String format;
}
