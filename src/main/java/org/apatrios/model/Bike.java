package org.apatrios.model;

import lombok.*;
import org.apatrios.model.dictoinary.ModelBike;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bike {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    private ModelBike modelBike;

    //Порядковый номер внутри модели
    private Integer seqNumber;

    // Инвентарный номер
    private Integer invNumber;

    private String vin;

    private String motorWheel;

    @OneToOne()
    private Iot iot;

    private BikeStatus status;

    @Column(columnDefinition = "text")
    private String comment;
}
