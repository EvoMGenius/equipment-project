package org.apatrios.model.equipment;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.ComponentModel;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@Table(name = "component")
@TypeDef(name = "json", typeClass = JsonType.class)
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

    /** Идентификаторы франчайзи */
    @Builder.Default
    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    Set<UUID> franchiseeIds = new HashSet<>();
}
