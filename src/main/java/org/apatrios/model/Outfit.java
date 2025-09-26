package org.apatrios.model;

import lombok.*;
import org.apatrios.model.dictoinary.OutfitModel;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Outfit {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    private OutfitModel model;

    // Инвентарный номер
    private Integer invNumber;

    private OutfitStatus status;

    @Column(columnDefinition = "text")
    private String comment;
}
