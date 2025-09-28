package org.apatrios.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollectionDto<T> {
    private List<T> items = Collections.emptyList();
    private long totalCount = 0L;

    public CollectionDto(List<T> items) {
        this.items = items != null ? items : Collections.emptyList();
        this.totalCount = items != null ? items.size() : 0L;
    }

    public static <T> CollectionDto<T> empty() {
        return new CollectionDto<>();
    }

    public static <T> CollectionDto<T> of(Page<T> page) {
        return new CollectionDto<>(page.getContent(), page.getTotalElements());
    }
}