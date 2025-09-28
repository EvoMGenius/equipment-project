package org.apatrios.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.dictoinary.Point;

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
public class Movement extends BaseEntity {

    /** Дата и время создания записи */
    @Column(nullable = false, updatable = false)
    LocalDateTime createDate;

    /** Точка отправления */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "point_from")
    Point pointFrom;

    /** Точка назначения */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "point_to")
    Point pointTo;

    /** Дата и время завершения перемещения */
    LocalDateTime dateEnd;

    /** Статус */
    @Column(nullable = false)
    MovementStatus status;

    /** Дополнительная заметка */
    @Column(columnDefinition = "TEXT")
    String note;
}