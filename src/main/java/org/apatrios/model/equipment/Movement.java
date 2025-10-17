package org.apatrios.model.equipment;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
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
    LocalDateTime startDate;

    /** Точка отправления */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "point_from")
    Point pointFrom;

    /** Точка назначения */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "point_to")
    Point pointTo;

    /** Дата и время завершения перемещения */
    LocalDateTime dateEnd;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    MovementStatus status;

    /** Дополнительная заметка */
    @Column(columnDefinition = "text")
    String note;

    /** Дата и время создания */
    @Column(nullable = false)
    LocalDateTime createDate;

    /** Дата и время обновления */
    LocalDateTime updateDate;

    /** Признак удаления */
    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean isDeleted = false;
}