package org.apatrios.model.services;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.ModelBike;
import org.apatrios.model.dictoinary.RejectionReason;
import org.apatrios.model.dictoinary.ServiceType;
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
public class Request extends BaseEntity {

    /** Контактная информация */
    @Embedded
    RequestProfile requestProfile;

    /** Тип услуги */
    @ManyToOne(fetch = FetchType.LAZY)
    ServiceType serviceType;

    /** Модель велосипеда */
    @ManyToOne(fetch = FetchType.LAZY)
    ModelBike modelBike;

    /** Комментарий */
    @Column(columnDefinition = "text")
    String note;

    /** Клиент */
    @ManyToOne(fetch = FetchType.LAZY)
    Client client;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    RequestStatus status;

    /** Обоснование отклонения */
    @ManyToOne(fetch = FetchType.LAZY)
    RejectionReason rejectionReason;

    /** Комментарий к отклонению */
    @Column(columnDefinition = "text")
    String rejectNote;

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