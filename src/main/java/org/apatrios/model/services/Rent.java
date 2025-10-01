package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.management.PaymentStatus;
import org.apatrios.model.management.Staff;

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
public class Rent extends BaseEntity {

    /** Администратор */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Staff staff;

    /** Дата и время начала аренды */
    @Column(nullable = false)
    LocalDateTime rentStart;

    /** Дата и время окончания аренды */
    @Column(nullable = false)
    LocalDateTime rentEnd;

    /** Статус аренды */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    RentStatus rentStatus;

    /** Клиент */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Client client;

    /** Статус оплаты */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    PaymentStatus paymentStatus;

    /** Комментарий */
    @Column(columnDefinition = "text")
    String comment;

    /** Родительская аренда */
    @ManyToOne(fetch = FetchType.LAZY)
    Rent parentRent;

    /** Родительская заявка */
    @ManyToOne(fetch = FetchType.LAZY)
    Request parentRequest;

    /** Дата и время создания */
    @Column(nullable = false)
    LocalDateTime createDate;

    /** Дата и время обновления */
    @Column(nullable = false)
    LocalDateTime updateDate;

    /** Признак удаления */
    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean isDeleted;
}
