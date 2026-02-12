package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.equipment.Status;

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
    @JoinColumn(name = "tariff_type_id")
    Dict tariffType;

    /** Начальная граница применения тарифа */
    Integer startBorder;

    /** Конечная граница применения тарифа */
    Integer endBorder;

    /** Размер скидки в целых числах */
    Integer sale;

    /** Стоимость */
    BigDecimal cost;

    /** Статус */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    Status status;
}
