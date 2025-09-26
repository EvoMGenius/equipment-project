package org.apatrios.util;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apatrios.model.dictoinary.EntityStatus;
import org.apatrios.model.dictoinary.QBaseDictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Неплохая наглядная реализация паттерна Builder для Predicate
 */
//todo add null-safety
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QPredicates {

    private final List<Predicate> predicates = new ArrayList<>();

    public <T> QPredicates add(T object, Function<T, Predicate> function) {
        if (object != null) {
            predicates.add(function.apply(object));
        }
        return this;
    }

    public static Predicate buildBasePredicate(String name, EntityStatus status) {
        QBaseDictionary entity = QBaseDictionary.baseDictionary;
        BooleanBuilder builder = new BooleanBuilder();

        if (name != null && !name.isEmpty()) {
            builder.and(entity.name.containsIgnoreCase(name));
        }

        if (status != null) {
            builder.and(entity.status.eq(status));
        }

        return builder;
    }

    public Predicate buildAnd() {
        Predicate predicate = ExpressionUtils.allOf(predicates);
        if (predicate == null) {
            return new BooleanBuilder();
        }
        return predicate;
    }

    public Predicate buildOr() {
        Predicate predicate = ExpressionUtils.anyOf(predicates);
        if (predicate == null) {
            return new BooleanBuilder();
        }
        return predicate;
    }

    public static QPredicates builder() {
        return new QPredicates();
    }
}