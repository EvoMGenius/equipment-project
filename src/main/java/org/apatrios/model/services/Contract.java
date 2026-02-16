package org.apatrios.model.services;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.management.Document;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Contract extends BaseEntity {

    /** Рекрутинговая компания */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_id")
    Recruit recruit;

    /*** Документ */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id")
    Document doc;

    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ContactStatus status;
}
