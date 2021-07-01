package com.br.casadokodigo.kasadokodigo.validation;



import javax.persistence.EntityManager;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
    private EntityManager em;

    private Class<?> klazz;
    private String field;

    public UniqueValueValidator(EntityManager em) {
        this.em = em;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return this.em.createQuery("select 1 from "+this.klazz.getName()+" where "+ field+"=:field")
                .setParameter("field",value)
                .getResultList()
                .isEmpty();
    }

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.klazz = constraintAnnotation.instanceClass();
        this.field = constraintAnnotation.field();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}