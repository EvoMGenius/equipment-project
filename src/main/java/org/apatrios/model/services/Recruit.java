package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Recruit extends BaseEntity {

    /** Клиент */
    @ManyToOne(fetch = FetchType.LAZY)
    Client client;

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
