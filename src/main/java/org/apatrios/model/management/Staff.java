package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
public class Staff extends BaseEntity {

    /** Фамилия */
    @Column(nullable = false)
    String surname;

    /** Имя */
    @Column(nullable = false)
    String name;

    /** Должность */
    @Column(nullable = false)
    String position;

    /** Внешний ключ: Бизнес-объект "Компания" */
    @ManyToOne(fetch = FetchType.LAZY)
    Company company;

    /** Контактный номер */
    String phone;

    /** Рабочий email */
    String email;

    /** Cтатус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    StaffStatus status;

    /** Дата и время создания записи */
    @CreationTimestamp
    LocalDateTime createDate;

    /** Дата и время последнего обновления записи */
    @UpdateTimestamp
    LocalDateTime updateDate;

    /** Признак логического удаления */
    @Builder.Default
    Boolean isDeleted = false;
}
