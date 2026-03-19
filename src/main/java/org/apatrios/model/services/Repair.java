package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.management.Point;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.time.LocalDateTime;
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
public class Repair extends BaseEntity {

    /** Номер заявки на ремонт */
    @Column(nullable = false, unique = true)
    String number;

    /** Тип произведенного ремонта */
    @Column(nullable = false)
    String fixType;

    /** Проблема со слов клиента */
    @Column(nullable = false)
    String problem;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    RepairStatus status;

    /** Дата создания заявки на ремонт */
    @CreationTimestamp
    LocalDateTime createDate;

    /** Сервисный центр */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_id")
    Point point;

    /** Фотографии */
    @ElementCollection
    @CollectionTable(
            name = "repair_photo",
            joinColumns = @JoinColumn(name = "repair_id")
    )
    List<Photo> photos = new ArrayList<>();
}
