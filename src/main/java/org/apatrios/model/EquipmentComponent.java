package org.apatrios.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.dictoinary.ComponentModel;

import javax.persistence.*;

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
    @ManyToOne(fetch = FetchType.EAGER)
    ComponentModel model;

    /** Инвентарный номер компонента */
    @Column(nullable = false)
    Integer invNumber;

    /** Статус компонента */
    @Column(nullable = false)
    String status;

    /** Комментарий */
    @Column(columnDefinition = "text")
    String comment;
}
