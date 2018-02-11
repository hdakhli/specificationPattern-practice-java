package com.dojo.specifications.pattern;

public abstract class AbstractCompositeSpecification<T> implements ISpecification<T> {

    public ISpecification or(ISpecification specification) {
        return new OrSpecification(this, specification);
    }

    public ISpecification and(ISpecification specification) {
        return new AndSpecification(this, specification);
    }

    public ISpecification not() {
        return new NotSpecification(this);
    }
}