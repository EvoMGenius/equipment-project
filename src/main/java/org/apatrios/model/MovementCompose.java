package org.apatrios.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
    @ManyToOne(fetch = FetchType.EAGER)
    Movement movement;

    /** ID велосипеда, экипировки или запчасти */
    @Column(nullable = false)
    UUID objectId;

    /** Количество объектов */
    @Column(nullable = false)
    Integer amount;

    /** Дополнительная заметка */
    @Column(columnDefinition = "TEXT")
    String note;
}