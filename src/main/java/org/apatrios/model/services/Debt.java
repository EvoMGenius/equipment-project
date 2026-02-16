package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.management.Document;

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
public class Debt extends BaseEntity {

    /** Тип задолженности */
    @Column(nullable = false)
    Dict debtType;

    /** Сумма начисления */
    BigDecimal total;

    /** Описание за что начислена задолженность */
    String description;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    DebtStatus status;

    /** Документ */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id")
    Document document;
}
