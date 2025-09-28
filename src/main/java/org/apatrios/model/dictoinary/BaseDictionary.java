package org.apatrios.model.dictoinary;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@MappedSuperclass
@FieldDefaults(level = PRIVATE)
@Getter
@Setter
public abstract class BaseDictionary extends BaseEntity {

    /** Наименование */
    @Column(nullable = false)
    String name;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    EntityStatus status = EntityStatus.ACTIVE;

    /** Дата создания */
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    LocalDateTime createDate;
}