package org.apatrios.model;

import lombok.*;
import org.apatrios.model.dictoinary.IotModel;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Iot {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    private IotModel model;

    private String invNumber;

    @OneToOne
    private Sim sim;

    private BikeStatus status;

    @Column(columnDefinition = "text")
    private String comment;
}
