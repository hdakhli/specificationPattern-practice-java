package com.dojo.services;

import com.dojo.domain.Phone;
import com.dojo.domain.PhoneBrand;
import com.dojo.domain.PhoneType;
import com.dojo.repositories.IPhoneRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PhoneServiceTest {

    @Mock
    IPhoneRepository phoneRepository;

    @InjectMocks
    PhoneService phoneService;

    @Before
    public void setUp() {
        List<Phone> phones = Arrays.asList(
                new Phone.Builder(PhoneBrand.BLACKBERRY, PhoneType.SMART, 300).build(),
                new Phone.Builder(PhoneBrand.SAMSUNG, PhoneType.SMART, 600).version(3).rate(4).build(),
                new Phone.Builder(PhoneBrand.SAMSUNG, PhoneType.SMART, 150).version(2).rate(2).build(),
                new Phone.Builder(PhoneBrand.SAMSUNG, PhoneType.BASIC, 30).build(),
                new Phone.Builder(PhoneBrand.APPLE, PhoneType.SMART, 800).version(2).rate(5).build(),
                new Phone.Builder(PhoneBrand.APPLE, PhoneType.SMART, 500).rate(5).build(),
                new Phone.Builder(PhoneBrand.ALCATEL, PhoneType.BASIC, 410).build(),
                new Phone.Builder(PhoneBrand.GOOGLE, PhoneType.SMART, 400).build(),
                new Phone.Builder(PhoneBrand.HTC, PhoneType.SMART, 400).build(),
                new Phone.Builder(PhoneBrand.HTC, PhoneType.BASIC, 29.90f).build(),
                new Phone.Builder(PhoneBrand.HUAWEI, PhoneType.SMART, 180).build(),
                new Phone.Builder(PhoneBrand.MOTOROLA, PhoneType.SMART, 150).rate(3).build(),
                new Phone.Builder(PhoneBrand.NOKIA, PhoneType.BASIC, 50).rate(5).build()
        );
        when(phoneRepository.findAllPhones()).thenReturn(phones);
    }

    @Test
    public void getAllPhones() {
        // When
        List<Phone> result = phoneService.getAllPhones();
        // Then
        assertEquals(13, result.size());
    }

    @Test
    public void getAllPremiumPhones() {
        // When
        List<Phone> result = phoneService.getAllPremiumPhones();
        // Then
        assertEquals(5, result.size());
    }

    @Test
    public void getSamsungPhones() {
        // When
        List<Phone> result = phoneService.getSamsungPhones();
        // Then
        assertEquals(3, result.size());
    }

    @Test
    public void getPremiumSamsungPhones() {
        // When
        List<Phone> result = phoneService.getPremiumSamsungPhones();
        // Then
        assertEquals(1, result.size());
    }

    @Test
    public void getSamsungAndHTCPhones() {
        // When
        List<Phone> result = phoneService.getSamsungAndHTCPhones();
        // Then
        assertEquals(5, result.size());
    }

    @Test
    public void getPremiumSamsungAndHTCPhones() {
        // When
        List<Phone> result = phoneService.getPremiumSamsungAndHTCPhones();
        // Then
        assertEquals(2, result.size());
    }

    @Test
    public void getAllExceptSamsungPhones() {
        // When
        List<Phone> result = phoneService.getAllExceptSamsungPhones();
        // Then
        assertEquals(10, result.size());
    }

    @Test
    public void getAllPremiumExceptSamsungAndHTCPhones() {
        // When
        List<Phone> result = phoneService.getAllPremiumExceptSamsungAndHTCPhones();
        // Then
        assertEquals(3, result.size());
    }
}