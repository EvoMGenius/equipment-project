package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.Dict;
import org.apatrios.model.equipment.Status;
import org.apatrios.model.management.Point;

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
    Dict fixType;

    /** Проблема со слов клиента */
    @Column(nullable = false)
    String problem;

    /** Статус */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    Status status;

    /** Дата создания заявки на ремонт */
    @Column(nullable = false)
    LocalDateTime createDate;

    /** Сервисный центр */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_id")
    Point point;

    /** Фотографии */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "repair_id")
    @Builder.Default
    List<Photo> photos = new ArrayList<>();
}
