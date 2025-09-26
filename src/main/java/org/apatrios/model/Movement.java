package org.apatrios.model;

import lombok.*;
import org.apatrios.model.dictoinary.Point;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "movement")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movement {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_from")
    private Point pointFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_to")
    private Point pointTo;

    @Column(name = "date_end")
    private LocalDateTime dateEnd;

    private MovementStatus status;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;
}