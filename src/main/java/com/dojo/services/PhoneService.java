package com.dojo.services;

import com.dojo.domain.Phone;
import com.dojo.repositories.IPhoneRepository;

import javax.inject.Inject;
import java.util.List;

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
        return phoneRepository.findAllPhones().stream().filter(phone -> phone.getCost() >= 400).collect(Collectors.toList());
    }

    public List<Phone> getSamsungPhones() {
        return phoneRepository.findAllPhones().stream().filter(phone -> phone.getBrand().equals(PhoneBrand.SAMSUNG)).collect(Collectors.toList());
    }

    public List<Phone> getPremiumSamsungPhones() {
        return phoneRepository.findAllPhones().stream().filter(phone -> phone.getBrand().equals(PhoneBrand.SAMSUNG) && phone.getCost() >= 400).collect(Collectors.toList());
    }

    public List<Phone> getSamsungAndHTCPhones() {
        return phoneRepository.findAllPhones().stream().filter(phone -> phone.getBrand().equals(PhoneBrand.SAMSUNG) || phone.getBrand().equals(PhoneBrand.HTC)).collect(Collectors.toList());
    }

    public List<Phone> getPremiumSamsungAndHTCPhones() {
        return phoneRepository.findAllPhones().stream().filter(phone -> (phone.getBrand().equals(PhoneBrand.SAMSUNG) || phone.getBrand().equals(PhoneBrand.HTC)) && phone.getCost() >= 400).collect(Collectors.toList());
    }

    public List<Phone> getAllExceptSamsungPhones() {
        return phoneRepository.findAllPhones().stream().filter(phone -> !phone.getBrand().equals(PhoneBrand.SAMSUNG)).collect(Collectors.toList());
    }

    public List<Phone> getAllPremiumExceptSamsungAndHTCPhones() {
        return phoneRepository.findAllPhones().stream().filter(phone -> !phone.getBrand().equals(PhoneBrand.SAMSUNG) && !phone.getBrand().equals(PhoneBrand.HTC) && phone.getCost() >= 400).collect(Collectors.toList());
    }

}
