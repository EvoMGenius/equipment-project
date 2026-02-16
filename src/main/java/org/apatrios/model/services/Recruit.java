package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;

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
public class Recruit extends BaseEntity {

    /** Компания, в которую хочет устроится пользователь */
    @Column(nullable = false)
    String recruitCompanyName;

    /** Дата начала */
    @Column(nullable = false)
    LocalDateTime createDate;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    RecruitStatus status;
}
