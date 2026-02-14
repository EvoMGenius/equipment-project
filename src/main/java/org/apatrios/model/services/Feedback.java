package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.Dict;

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
public class Feedback extends BaseEntity {

    /*** Тип родительской сущности */
    @Column(nullable = false)
    Dict entityType;

    /** * ID родительской сущности */
    @Column(nullable = false)
    UUID parentEntityId;

    /*** Текстовое описание отзыва */
    @Column(nullable = false, columnDefinition = "text")
    String description;

    /** * Оценка от 1 до 5 */
    @Column(nullable = false)
    Integer evaluation;
}
