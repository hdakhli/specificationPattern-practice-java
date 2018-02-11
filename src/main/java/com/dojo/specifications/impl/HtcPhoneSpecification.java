package com.dojo.specifications.impl;

import com.dojo.domain.Phone;
import com.dojo.domain.PhoneBrand;
import com.dojo.specifications.pattern.AbstractCompositeSpecification;

public class HtcPhoneSpecification extends AbstractCompositeSpecification<Phone> {

    @Override
    public boolean isSatisfiedBy(Phone phone) {
            return phone.getBrand().equals(PhoneBrand.HTC);
    }
}
