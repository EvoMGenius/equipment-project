package org.apatrios.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.dictoinary.IotModel;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Iot extends BaseEntity {

    /** Справочник моделей IoT-устройств */
    @ManyToOne(fetch = FetchType.EAGER)
    IotModel model;

    /** Инвентарный номер */
    @Column(nullable = false)
    String invNumber;

    /** SIM-карта */
    @OneToOne(fetch = FetchType.EAGER)
    Sim sim;

    /** Статус */
    @Column(nullable = false)
    BikeStatus status;

    /** Комментарий */
    @Column(columnDefinition = "text")
    String comment;
}
