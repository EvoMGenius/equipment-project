package org.apatrios.model.dictoinary;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(name = "service")
public class ServiceDictionary extends BaseDictionary {
}
