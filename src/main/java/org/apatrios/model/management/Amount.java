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
public class Amount {
    /** Сумма оплаты */
    @Column(name = "amount_value", nullable = false)
    BigDecimal value;

    /** Валюта */
    @Column(name = "amount_currency", nullable = false)
    String currency;
}
