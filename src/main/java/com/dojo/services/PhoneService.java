package com.dojo.services;

import com.dojo.domain.Phone;
import com.dojo.domain.PhoneBrand;
import com.dojo.repositories.IPhoneRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneService implements IPhoneService {

    @Inject
    IPhoneRepository phoneRepository;

    public List<Phone> getAllPhones() {
        return phoneRepository.findAllPhones();
    }

    /**
     * premium phones: cost >= 400
     */
    public List<Phone> getAllPremiumPhones() {
        return phoneRepository.findAllPhones();
    }

    public List<Phone> getSamsungPhones() {
        return phoneRepository.findAllPhones();
    }

    public List<Phone> getPremiumSamsungPhones() {
        return phoneRepository.findAllPhones();
    }

    public List<Phone> getSamsungAndHTCPhones() {
        return phoneRepository.findAllPhones();
    }

    public List<Phone> getPremiumSamsungAndHTCPhones() {
        return phoneRepository.findAllPhones();
    }

    public List<Phone> getAllExceptSamsungPhones() {
        return phoneRepository.findAllPhones();
    }

    public List<Phone> getAllPremiumExceptSamsungAndHTCPhones() {
        return phoneRepository.findAllPhones();
    }

}
