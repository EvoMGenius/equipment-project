package org.apatrios.model.equipment;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.IotModel;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@TypeDef(name = "json", typeClass = JsonType.class)
public class Iot extends BaseEntity {

    /** Справочник моделей IoT-устройств */
    @ManyToOne(fetch = FetchType.LAZY)
    IotModel model;

    /** Инвентарный номер */
    @Column(nullable = false)
    String invNumber;

    /** Международный идентификатор мобильного оборудования */
    @Column(nullable = false)
    String imei;

    /** SIM-карта */
    @OneToOne(fetch = FetchType.LAZY)
    Sim sim;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    IotStatus status;

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

    /** Идентификаторы франчайзи */
    @Builder.Default
    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    Set<UUID> franchiseeIds = new HashSet<>();
}
