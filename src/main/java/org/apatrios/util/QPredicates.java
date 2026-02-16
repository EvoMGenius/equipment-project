package org.apatrios.util;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.flywaydb.core.internal.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Реализация паттерна Builder для Predicate с null-safety.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QPredicates {

    private final List<Predicate> predicates = new ArrayList<>();

    public <T> QPredicates add(T object, Function<T, Predicate> function) {
        if (object == null || function == null) {
            return this;
        }

        Predicate p;
        try {
            p = function.apply(object);
        } catch (Exception e) {
            return this;
        }

        if (p != null) {
            predicates.add(p);
        }
        return this;
    }

    public QPredicates add(Predicate predicate) {
        if (predicate != null) {
            this.predicates.add(predicate);
        }
        return this;
    }

    public Predicate buildAnd() {
        Predicate predicate = ExpressionUtils.allOf(predicates);
        if (predicate == null) {
            return new BooleanBuilder();
        }
        return predicate;
    }

    @SafeVarargs
    public final QPredicates addAnyString(String value, Function<String, BooleanExpression>... conditions) {
        if (!StringUtils.hasText(value)) {
            return this;
        }

        if (conditions == null || conditions.length == 0) {
            return this;
        }
        BooleanExpression predicate = conditions[0].apply(value);

        for (int i = 1; i < conditions.length; i++) {
            BooleanExpression temp = conditions[i].apply(value);
            if (temp != null) {
                predicate = predicate.or(temp);
            }
        }

        if (predicate != null) {
            predicates.add(predicate);
        }


        return this;
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