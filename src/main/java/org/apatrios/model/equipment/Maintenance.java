package org.apatrios.model.equipment;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@TypeDef(name = "json", typeClass = JsonType.class)
public class Maintenance extends BaseEntity {

    /** VIN электровелосипеда */
    @Column(nullable = false)
    String bicycleVin;

    /** Выполненные работы */
    @Type(type = "json")
    @Column(columnDefinition = "jsonb not null default '[]'")
    List<String> completedWork;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    MaintenanceStatus status;

    /** Дата и время начала техобслуживания */
    LocalDateTime startDate;

    /** Дата и время окончания техобслуживания */
    LocalDateTime endDate;

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
