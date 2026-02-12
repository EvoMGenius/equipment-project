package org.apatrios.model.equipment;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.management.Tariff;
import org.apatrios.model.management.Telemetry;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Bike extends BaseEntity {

    /** Инвентарный номер */
    @Column(nullable = false, unique = true)
    String invNumber;

    /** Ссылка на модель велосипеда */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    ModelBike modelBike;

    /** Последние данные телеметрии */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "telemetry_id")
    Telemetry telemetry;

    /** Флаг блокировки */
    Boolean isBlocked;

    /** Состояние сигнализации */
    Boolean isAlarmOn;

    /** Состояние фонарей */
    Boolean isHeadlightsOn;

    /** Список доступных тарифов для этого велосипеда */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "bike_tariffs",
            joinColumns = @JoinColumn(name = "bike_id"),
            inverseJoinColumns = @JoinColumn(name = "tariff_id")
    )
    @Builder.Default
    List<Tariff> tariff = new ArrayList<>();

    /** Текущий выбранный тариф */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chosen_tariff_id")
    Tariff chosenTariff;

    /** Статус */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    Status status;
}
