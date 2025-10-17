package org.apatrios.model.equipment;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.ComponentModel;

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
@Table(name = "component")
public class EquipmentComponent extends BaseEntity {

    /** Справочник моделей компонентов */
    @ManyToOne(fetch = FetchType.LAZY)
    ComponentModel model;

    /** Инвентарный номер компонента */
    @Column(nullable = false)
    Integer invNumber;

    /** Статус компонента */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    EquipmentComponentStatus status;

    /** Комментарий */
    @Column(columnDefinition = "text")
    String comment;

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
