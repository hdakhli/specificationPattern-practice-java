package com.dojo.specifications.impl;

import com.dojo.domain.Phone;
import com.dojo.domain.PhoneType;
import com.dojo.specifications.pattern.AbstractCompositeSpecification;

public class PremiumPhoneSpecification extends AbstractCompositeSpecification<Phone> {

    @Override
    public boolean isSatisfiedBy(Phone phone) {
        return phone.getCost() >= 400 && !PhoneType.BASIC.equals(phone.getType());
    }
}
