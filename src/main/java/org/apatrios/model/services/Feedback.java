package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.ServiceDictionary;

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
public class Feedback extends BaseEntity {

    /** Услуга */
    @ManyToOne(fetch = FetchType.LAZY)
    ServiceDictionary serviceDictionary;

    /** Оценка от 1 до 5 */
    @Column(nullable = false)
    Integer rate;

    /** Текст отзыва */
    @Column(nullable = false)
    String note;

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
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "feedback_franchisee")
    @Column(name = "franchisee_id")
    Set<UUID> franchiseeIds = new HashSet<>();
}
