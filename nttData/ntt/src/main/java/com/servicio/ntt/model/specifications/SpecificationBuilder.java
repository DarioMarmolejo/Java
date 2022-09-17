package com.servicio.ntt.model.specifications;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.servicio.ntt.exception.BadRequestException;
import com.servicio.ntt.model.filter.Filter;

import static org.springframework.data.jpa.domain.Specification.where;


@Component
public class SpecificationBuilder<T> {
    
    public Specification<T> getSpecificationFromFilters(List<Filter> filter) {
        if(filter.isEmpty()){return null;}
        Specification<T> specification = where(createSpecification(filter.remove(0)));
        for (Filter input : filter) {
            specification = specification.and(createSpecification(input));
        }
        return specification;
    }    

    private Specification<T> createSpecification(Filter input) {
        switch (input.getOperator()) {
            case BINNAR:
                return (root, query, criteriaBuilder) -> criteriaBuilder.isTrue(root.get(input.getValue()).as(Boolean.class));
            case EQUALS:
                return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(input.getField()),
                        castToRequiredType(root.get(input.getField()).getJavaType(), input.getValue()));
            case NOT_EQ:
                return (root, query, criteriaBuilder) -> criteriaBuilder.notEqual(root.get(input.getField()),
                        castToRequiredType(root.get(input.getField()).getJavaType(), input.getValue()));
            case GREATER_THAN:
                return (root, query, criteriaBuilder) -> criteriaBuilder.gt(root.get(input.getField()),
                        (Number) castToRequiredType(root.get(input.getField()).getJavaType(), input.getValue()));
            case LESS_THAN:
                return (root, query, criteriaBuilder) -> criteriaBuilder.lt(root.get(input.getField()),
                        (Number) castToRequiredType(root.get(input.getField()).getJavaType(), input.getValue()));
            case GREATER_THAN_DATE:
                DateTimeFormatter dateFormatterMin = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate dateFormMin = LocalDate.parse(input.getValue(), dateFormatterMin);
                return (root, query, criteriaBuilder) -> criteriaBuilder
                        .greaterThanOrEqualTo(root.get(input.getField()), dateFormMin);
            case GREATER_THAN_DATE_TIME_STAMP:
                DateTimeFormatter dateFormatterMinTimeStamp = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss'Z'");
                LocalDateTime dateFormMinTimeStamp = LocalDateTime.parse(input.getValue(), dateFormatterMinTimeStamp);
                return (root, query, criteriaBuilder) -> criteriaBuilder
                        .greaterThanOrEqualTo(root.get(input.getField()), dateFormMinTimeStamp);
            case LESS_THAN_DATE:
                DateTimeFormatter dateFormatterMax = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate dateFormMax = LocalDate.parse(input.getValue(), dateFormatterMax);
                return (root, query, criteriaBuilder) -> criteriaBuilder
                        .lessThanOrEqualTo(root.get(input.getField()), dateFormMax);
            case LESS_THAN_DATE_TIME_STAMP:
                DateTimeFormatter dateFormatterMaxTimeStamp = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss'Z'");
                LocalDateTime dateFormMaxTimeStamp = LocalDateTime.parse(input.getValue(), dateFormatterMaxTimeStamp);
                return (root, query, criteriaBuilder) -> criteriaBuilder
                        .lessThanOrEqualTo(root.get(input.getField()), dateFormMaxTimeStamp);
            case LIKE:
                return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(input.getField()),
                        "%" + input.getValue() + "%");
            case IN:
                return (root, query, criteriaBuilder) -> criteriaBuilder.in(root.get(input.getField()))
                        .value(castToRequiredType(root.get(input.getField()).getJavaType(), input.getValues()));
            default:
                throw new BadRequestException("Operacion no soportada",Arrays.asList("Operator"));
        }
    }

    private Object castToRequiredType(Class<? extends Object> fieldType, String value) {
        if (fieldType.isAssignableFrom(Double.class)) {
            return Double.valueOf(value);
        } else if (fieldType.isAssignableFrom(Integer.class)) {
            return Integer.valueOf(value);
        }
        return null;
    }

    private Object castToRequiredType(Class<? extends Object> fieldType, List<String> value) {
        List<Object> lists = new ArrayList<>();
        for (String s : value) {
            lists.add(castToRequiredType(fieldType, s));
        }
        return lists;
    }
    
}
