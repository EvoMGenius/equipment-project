package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.ClaimType;

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
public class Claim extends BaseEntity {

    /** Родительская аренда */
    @ManyToOne(fetch = FetchType.LAZY)
    Rent parentRent;

    /** Тип претензии */
    @ManyToOne(fetch = FetchType.LAZY)
    ClaimType claimType;

    /** Дата и время начала претензии */
    @Column(nullable = false)
    LocalDateTime startDate;

    /** Дата решения */
    LocalDateTime endDate;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ClaimStatus status;

    /** Комментарий */
    @Column(columnDefinition = "text")
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
    @CollectionTable(name = "claim_franchisee")
    @Column(name = "franchisee_id")
    Set<UUID> franchiseeIds = new HashSet<>();
}
