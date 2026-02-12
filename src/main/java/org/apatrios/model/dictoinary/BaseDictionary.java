package org.apatrios.model.dictoinary;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@MappedSuperclass
@FieldDefaults(level = PRIVATE)
@Getter
@Setter
public abstract class BaseDictionary extends BaseEntity {
    /** Наименование */
    @Column(nullable = false)
    String name;
}