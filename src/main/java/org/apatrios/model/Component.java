package org.apatrios.model;

import lombok.*;
import org.apatrios.model.dictoinary.ComponentModel;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Component {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    private ComponentModel model; // справочник моделей

    // Инвентарный номер
    private Integer invNumber;

    private String status; //status

    @Column(columnDefinition = "text")
    private String comment;
}
