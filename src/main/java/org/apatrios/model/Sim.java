package org.apatrios.model;

import lombok.*;
import org.apatrios.model.dictoinary.Operator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sim {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    private String phoneNumber;

    @ManyToOne
    private Operator operator; // Справочник
}
