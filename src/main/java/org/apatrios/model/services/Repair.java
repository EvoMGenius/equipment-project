package org.apatrios.model.services;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.RepairType;
import org.apatrios.model.management.Staff;
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
@TypeDef(name = "json", typeClass = JsonType.class)
public class Repair extends BaseEntity {

    /** ID велосипеда, экипировки или запчасти */
    @Column(nullable = false)
    UUID objectId;

    /** Тип ремонта */
    @ManyToOne(fetch = FetchType.LAZY)
    RepairType repairType;

    /** Исполнитель */
    @ManyToOne(fetch = FetchType.LAZY)
    Staff staff;

    /** Выполненные работы */
    @Column(columnDefinition = "text")
    String description;

    /** Статус ремонта */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    RepairStatus status;

    /** Дата и время начала ремонта */
    @Column(nullable = false)
    LocalDateTime createDate;

    /** Дата и время фактического завершения ремонта */
    LocalDateTime dateEnd;

    /** Дата и время обновления */
    LocalDateTime updateDate;

    /** Признак удаления */
    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean isDeleted = false;

    /** Комментарий */
    @Column(columnDefinition = "text")
    String comment;

    /** Идентификаторы франчайзи */
    @Builder.Default
    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    Set<UUID> franchiseeIds = new HashSet<>();
}
