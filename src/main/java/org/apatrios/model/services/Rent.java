package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.RentType;
import org.apatrios.model.equipment.Bike;
import org.apatrios.model.equipment.Outfit;
import org.apatrios.model.management.Document;
import org.apatrios.model.management.Payment;
import org.apatrios.model.management.Point;
import org.apatrios.model.management.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Rent extends BaseEntity {

    /** Тип аренды */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rent_type_id")
    RentType rentType;

    /** Последний созданный платеж для этой аренды */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    Payment payment;

    /** Номер аренды */
    @Column(nullable = false, unique = true)
    String number;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    RentStatus status;

    /** Пользователь, которому принадлежит аренда */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    /** Электровелосипед */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bike_id")
    Bike bike;

    /** Пункт выдачи */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_id")
    Point point;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rent_id")
    @Builder.Default
    List<Debt> debts = new ArrayList<>();

    /** Дата начала аренды */
    LocalDateTime startDate;

    /** Дата окончания аренды */
    LocalDateTime endDate;

    /** Стоимость аренды с учетом экипировки */
    Integer total;

    /** Количество прошедших дней */
    Integer currentDays;

    /** Просрочка в днях */
    Integer delay;

    /** Стоимость просрочки */
    BigDecimal delayCost;

    /** Экипировка */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "rent_outfits",
            joinColumns = @JoinColumn(name = "rent_id"),
            inverseJoinColumns = @JoinColumn(name = "outfit_id")
    )
    @Builder.Default
    List<Outfit> outfits = new ArrayList<>();

    /** Документы */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "rent_id")
    @Builder.Default
    List<Document> documents = new ArrayList<>();
}