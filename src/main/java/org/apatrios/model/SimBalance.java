package org.apatrios.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SimBalance {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    private Integer value;

    private Sim sim;

    private LocalDateTime createDate;
}
