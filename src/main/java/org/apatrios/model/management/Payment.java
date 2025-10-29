package org.apatrios.model.management;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.PaymentType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

import java.math.BigDecimal;
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
public class Payment extends BaseEntity {

    /** Сумма оплаты */
    @Column(nullable = false)
    BigDecimal amount;

    /** Валюта */
    @Column(nullable = false)
    String currency;

    /** Тип оплаты */
    @ManyToOne(fetch = FetchType.LAZY)
    PaymentType paymentType;

    /** Статус оплаты */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    PaymentStatus status;

    /** Внешний ключ на связанную сущность (аренда, услуга и т.д.) */
    @Column(nullable = false)
    UUID entityId;

    /** Тип связанной сущности (например "rent", "service") */
    @Column(nullable = false)
    String entityType;

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
    @Builder.Default
    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    Set<UUID> franchiseeIds = new HashSet<>();
}
