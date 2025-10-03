package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;

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
public class Franchisee extends BaseEntity {

    /** Контактная информация франчайзи */
    @Embedded
    FranchiseeProfile franchiseeProfile;

    /** Идентификационный номер налогоплательщика */
    @Column(nullable = false)
    String inn;

    /** Статус франчайзи */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    FranchiseeStatus status;

    /** Дата и время создания */
    @Column(nullable = false)
    LocalDateTime createDate;

    /** Дата и время обновления */
    LocalDateTime updateDate;

    /** Признак удаления */
    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean isDeleted;
}
