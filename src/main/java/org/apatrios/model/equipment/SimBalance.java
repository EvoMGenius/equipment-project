package org.apatrios.model.equipment;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class SimBalance extends BaseEntity {

    /** Баланс значение */
    @Column(nullable = false)
    Integer value;

    /** SIM-карта */
    @ManyToOne(fetch = FetchType.LAZY)
    Sim sim;

    /** Дата и время фиксации баланса */
    @CreationTimestamp
    LocalDateTime createDate;
}
