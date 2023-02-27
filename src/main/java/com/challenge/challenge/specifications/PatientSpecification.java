package com.challenge.challenge.specifications;

import com.challenge.challenge.models.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import static com.challenge.challenge.utils.RemoveAccents.*;


public class PatientSpecification implements Specification<Patient> {
    private PatientSpecification() {
    }

    public static Specification<Patient> filters(String filter) {
        filter = Normalizer.normalize(filter, Normalizer.Form.NFD)
                .replaceAll(DIACRITICAL_MARKS, "").trim().toLowerCase();
        String finalText = "%" + filter + "%";

        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            //NAME
            predicates.add(builder.like(builder.lower(builder.function(TRANSLATE_FUNCTION, String.class,
                    root.get(Patient_.name), builder.literal(LETRAS_ACENTOS),
                    builder.literal(LETRAS_SEM_ACENTOS))), finalText));
            //AGE
            predicates.add(builder.like(builder.lower(builder.function(TRANSLATE_FUNCTION, String.class,
                    root.get(Patient_.age).as(String.class), builder.literal(LETRAS_ACENTOS),
                    builder.literal(LETRAS_SEM_ACENTOS))), finalText));
            return builder.or(predicates.toArray(new Predicate[0]));
        };
    }

    @Override
    public Predicate toPredicate(Root<Patient> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
