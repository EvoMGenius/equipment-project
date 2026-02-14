package org.apatrios.model.dictoinary;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class PurchaseType extends BaseDictionary {
}
