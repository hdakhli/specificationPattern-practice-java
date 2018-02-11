package com.dojo.repositories;

import com.dojo.domain.Phone;

import java.util.List;

public interface IPhoneRepository {

    List<Phone> findAllPhones();

}
