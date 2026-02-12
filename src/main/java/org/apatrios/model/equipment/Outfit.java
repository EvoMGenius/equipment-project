package org.apatrios.model.equipment;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.management.Tariff;

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
public class Outfit extends BaseEntity {

    /** Название экипировки */
    @Column(nullable = false)
    String name;

    /** * Список доступных тарифов для данной экипировки.*/
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "outfit_tariffs",
            joinColumns = @JoinColumn(name = "outfit_id"),
            inverseJoinColumns = @JoinColumn(name = "tariff_id")
    )
    @Builder.Default
    List<Tariff> tariff = new ArrayList<>();

    /** * Выбранный тариф для текущей единицы экипировки
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chosen_tariff_id")
    Tariff chosenTariff;

    /** Статус */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    Status status;
}
