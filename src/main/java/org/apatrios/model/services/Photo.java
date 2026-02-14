package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Photo extends BaseEntity {
    @Column(nullable = false)
    String fileName;

    @Column(nullable = false)
    String fileUrl;
}
