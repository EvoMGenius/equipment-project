package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Company extends BaseEntity {

    /** Название организации */
    @Column(nullable = false)
    String name;

    /** ИНН */
    @Column(nullable = false)
    String inn;

    /** Юридический адрес */
    @Column(nullable = false)
    String address;

    /** Контактный телефон */
    @Column(nullable = false)
    String phone;

    /** Электронная почта */
    @Column(nullable = false)
    String email;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    CompanyStatus status;

    /** Дата и время создания записи */
    @CreationTimestamp
    LocalDateTime createDate;

    /** Дата и время обновления записи */
    @UpdateTimestamp
    LocalDateTime updateDate;

    /** Признак удаления */
    @Builder.Default
    Boolean isDeleted = false;
}
