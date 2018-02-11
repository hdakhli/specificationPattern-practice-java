package com.dojo.specifications.pattern;

public interface ISpecification<T> {

    boolean isSatisfiedBy(T candidate);

    ISpecification or(ISpecification specification);
    ISpecification and(ISpecification specification);
    ISpecification not();

}