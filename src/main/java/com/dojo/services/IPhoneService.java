package com.dojo.services;

import com.dojo.domain.Phone;

import java.util.List;

public interface IPhoneService {

    /**
     * @return All phones
     */
    List<Phone> getAllPhones();

    /**
     * Premium (cost >= 400)
     * @return All premium phones
     */
    List<Phone> getAllPremiumPhones();

    /**
     * @return Only brand Samsung
     */
    List<Phone> getSamsungPhones();

    /**
     * @return Only premium brand Samsung
     */
    List<Phone> getPremiumSamsungPhones();

    /**
     * @return Either brand Samsung or HTC
     */
    List<Phone> getSamsungAndHTCPhones();

    /**
     * @return All premium and brand Samsung or HTC
     */
    List<Phone> getPremiumSamsungAndHTCPhones();

    /**
     * @return All but brand Samsung
     */
    List<Phone> getAllExceptSamsungPhones();

    /**
     * @return All premium but brand Samsung and htc
     */
    List<Phone> getAllPremiumExceptSamsungAndHTCPhones();
}
