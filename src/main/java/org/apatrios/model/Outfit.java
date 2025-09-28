package org.apatrios.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.dictoinary.OutfitModel;

import javax.persistence.*;

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
    @ManyToOne(fetch = FetchType.EAGER)
    OutfitModel model;

    /** Инвентарный номер */
    @Column(nullable = false)
    Integer invNumber;

    /** Статус */
    @Column(nullable = false)
    OutfitStatus status;

    /** Комментарий */
    @Column(columnDefinition = "text")
    String comment;
}
