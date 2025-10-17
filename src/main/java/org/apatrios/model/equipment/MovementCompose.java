package org.apatrios.model.equipment;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;

import javax.persistence.*;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class MovementCompose extends BaseEntity {

    /** Перемещение */
    @ManyToOne(fetch = FetchType.LAZY)
    Movement movement;

    /** ID велосипеда, экипировки или запчасти */
    @Column(nullable = false)
    UUID objectId;

    /** Количество объектов */
    @Column(nullable = false)
    Integer amount;

    /** Дополнительная заметка */
    @Column(columnDefinition = "text")
    String note;
}