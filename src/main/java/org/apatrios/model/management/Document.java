package org.apatrios.model.management;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apatrios.model.BaseEntity;
import org.apatrios.model.dictoinary.Dict;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Document extends BaseEntity {
    /** Статус */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    DocumentStatus status;

    /** Название документа */
    String name;

    /** Тип документа */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_type_id")
    Dict docType;

    /** Информация о файле */
    @Embedded
    File file;
}
