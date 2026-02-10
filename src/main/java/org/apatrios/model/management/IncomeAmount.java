package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class IncomeAmount {
    /** Сумма оплаты */
    @Column(name = "income_value")
    BigDecimal value;

    /** Валюта */
    @Column(name = "income_currency")
    String currency;
}
