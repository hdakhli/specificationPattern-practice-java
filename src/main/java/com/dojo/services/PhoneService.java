package com.dojo.services;

import com.dojo.domain.Phone;
import com.dojo.repositories.IPhoneRepository;
import com.dojo.specifications.impl.HtcPhoneSpecification;
import com.dojo.specifications.impl.PremiumPhoneSpecification;
import com.dojo.specifications.impl.SamsungPhoneSpecification;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneService implements IPhoneService {

    @Inject
    IPhoneRepository phoneRepository;

    private PremiumPhoneSpecification premiumPhoneSpec = new PremiumPhoneSpecification();
    private SamsungPhoneSpecification samsungPhoneSpec = new SamsungPhoneSpecification();
    private HtcPhoneSpecification htcPhoneSpec = new HtcPhoneSpecification();

    public List<Phone> getAllPhones() {
        return phoneRepository.findAllPhones();
    }

    /**
     * premium phones: cost >= 400
     */
    public List<Phone> getAllPremiumPhones() {
        return phoneRepository.findAllPhones().stream().filter(phone -> premiumPhoneSpec.isSatisfiedBy(phone)).collect(Collectors.toList());
    }

    public List<Phone> getSamsungPhones() {
        return phoneRepository.findAllPhones().stream().filter(phone -> samsungPhoneSpec.isSatisfiedBy(phone)).collect(Collectors.toList());
    }

    public List<Phone> getPremiumSamsungPhones() {
        return phoneRepository.findAllPhones().stream().filter(phone -> premiumPhoneSpec.and(samsungPhoneSpec).isSatisfiedBy(phone)).collect(Collectors.toList());
    }

    public List<Phone> getSamsungAndHTCPhones() {
        return phoneRepository.findAllPhones().stream().filter(phone -> samsungPhoneSpec.or(htcPhoneSpec).isSatisfiedBy(phone)).collect(Collectors.toList());
    }

    public List<Phone> getPremiumSamsungAndHTCPhones() {
        return phoneRepository.findAllPhones().stream().filter(phone -> premiumPhoneSpec.and(samsungPhoneSpec.or(htcPhoneSpec)).isSatisfiedBy(phone)).collect(Collectors.toList());
    }

    public List<Phone> getAllExceptSamsungPhones() {
        return phoneRepository.findAllPhones().stream().filter(phone -> samsungPhoneSpec.not().isSatisfiedBy(phone)).collect(Collectors.toList());
    }

    public List<Phone> getAllPremiumExceptSamsungAndHTCPhones() {
        return phoneRepository.findAllPhones().stream().filter(phone -> premiumPhoneSpec.and(samsungPhoneSpec.or(htcPhoneSpec).not()).isSatisfiedBy(phone)).collect(Collectors.toList());
    }

}