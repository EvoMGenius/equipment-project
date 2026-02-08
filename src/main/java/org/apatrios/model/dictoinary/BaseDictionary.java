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

    /** Внешний ID записи */
    @Column(nullable = false)
    String dictId;

    /** Наименование справочников */
    @Column(nullable = false)
    String dictName;

    /** Поле для управления порядком вывода элементов справочника */
    @Column(nullable = false)
    Integer order;

    /** Язык */
    @Column(nullable = false)
    String locale;
}