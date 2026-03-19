package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
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
public class Support extends BaseEntity {
    /** Дата создания обращения */
    @CreationTimestamp
    LocalDateTime createDate;

    /** Тип обращения */
    @Column(nullable = false)
    String type;

    /** Описание проблемы */
    @Column(nullable = false)
    String description;

    /** * Фотографии */
    @ElementCollection
    @CollectionTable(
            name = "support_photo",
            joinColumns = @JoinColumn(name = "support_id")
    )
    List<Photo> photo = new ArrayList<>();

    /** * Идентификатор связанного ремонта */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_repair_id")
    Repair childRepairId;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    SupportStatus status;
}
