package org.apatrios.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "movement_compose")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovementCompose {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movement_id")
    private Movement movement;

    @Column(name = "object_id")
    private UUID objectId; // ID велосипеда, экипировки или запчасти

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;
}