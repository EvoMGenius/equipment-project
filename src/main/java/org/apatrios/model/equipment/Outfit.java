package org.apatrios.model.equipment;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.OutfitModel;
import org.apatrios.model.management.Franchisee;

import javax.persistence.*;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Outfit extends BaseEntity {

    /** Справочник моделей экипировки */
    @ManyToOne(fetch = FetchType.LAZY)
    OutfitModel model;

    /** Франчайзи */
    @ManyToOne(fetch = FetchType.LAZY)
    Franchisee franchisee;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    OutfitStatus status;

    /** Комментарий */
    @Column(columnDefinition = "text")
    String comment;

    /** Дата и время создания */
    @Column(nullable = false)
    LocalDateTime createDate;

    /** Дата и время обновления */
    LocalDateTime updateDate;

    /** Признак удаления */
    @Builder.Default
    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean isDeleted = false;
}
