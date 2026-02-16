package org.apatrios.model.management;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.dictoinary.PurchaseType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Map;

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

    /** * Тип платежа */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_type_id")
    PurchaseType paymentType;

    /** * Тип оплачиваемой сущности */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_type_id")
    Dict entityType;

    /** Валюта платежа */
    String currency;

    /** * Сумма платежа */
    BigDecimal amount;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    PaymentStatus status;

    /** Доп данные для оплаты */
    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    Map<String, String> metadata;
}
