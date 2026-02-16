package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.Dict;

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
    @Column(nullable = false)
    LocalDateTime createDate;

    /** Тип обращения */
    @Column(nullable = false)
    Dict type;

    /** Описание проблемы */
    @Column(nullable = false)
    String description;

    /** * Фотографии */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "support_id")
    @Builder.Default
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
