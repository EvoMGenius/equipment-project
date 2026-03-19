package org.apatrios.model.management;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.PaymentType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
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

    /** Валюта платежа */
    @Column(nullable = false)
    String currency;

    /*** Сумма платежа */
    @Column(nullable = false)
    BigDecimal amount;

    /*** Компания */
    @ManyToOne(fetch = FetchType.LAZY)
    Company company;

    /*** Тип платежа */
    @ManyToOne(fetch = FetchType.LAZY)
    PaymentType paymentType;

    /*** Внешний ключ на связанную сущность (аренда, услуга и т.д.) */
    UUID entityId;

    /*** Тип оплачиваемой сущности */
    String entityType;

    /** Дата востребования (используется при создании из заявки/аренды по тарифу) */
    LocalDateTime dateOfDemand;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    PaymentStatus status;

    /** Дата и время создания записи */
    @CreationTimestamp
    LocalDateTime createDate;

    /** Дата и время обновления записи */
    @UpdateTimestamp
    LocalDateTime updateDate;

    /** Признак удаления */
    @Builder.Default
    Boolean isDeleted = false;

    /** Доп данные для оплаты */
    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    Map<String, String> metadata;
}
