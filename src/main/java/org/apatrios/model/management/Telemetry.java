package org.apatrios.model.management;

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
public class Telemetry extends BaseEntity {

    /** Уровень заряда батареи */
    @Column(nullable = false)
    Integer battery;

    /** Широта */
    @Column(nullable = false)
    String latitude;

    /** Долгота */
    @Column(nullable = false)
    String longitude;
}
