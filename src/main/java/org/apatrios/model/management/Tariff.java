package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.TariffType;

import javax.persistence.*;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Tariff extends BaseEntity {
    /** Уникальный код тарифа */
    @Column(nullable = false, unique = true)
    String code;

    /** Тип тарифа */
    @ManyToOne(fetch = FetchType.LAZY)
    TariffType tariffType;

    /** Частота оплат (monthly, biweekly и т.п.) */
    @Column(nullable = false)
    String paymentFrequency;

    /** Сумма одного платежа */
    @Column(nullable = false)
    BigDecimal installmentAmount;

    /** Общее количество платежей */
    @Column(nullable = false)
    Integer installmentCount;

    /** Нижняя граница тарифа (дни), nullable */
    Integer startBorder;

    /** Верхняя граница тарифа (дни), nullable */
    Integer endBorder;

    /** Скидка предоставляемая за период аренды (в денежном виде) */
    BigDecimal sale;

    /** Стоимость с учетом скидки */
    BigDecimal cost;

    /** Стоимость указанная менеджером (переопределяет расчетную) */
    BigDecimal customPrice;

    /** Статус тарифа для отображения */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TariffStatus status;
}
