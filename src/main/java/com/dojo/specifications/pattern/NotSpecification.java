package com.dojo.specifications.pattern;

public class NotSpecification<T> extends AbstractCompositeSpecification<T> {

    private ISpecification specification;

    public NotSpecification(ISpecification specification) {
        this.specification = specification;
    }

    public boolean isSatisfiedBy(T candidate) {
        return !specification.isSatisfiedBy(candidate);
    }

}
