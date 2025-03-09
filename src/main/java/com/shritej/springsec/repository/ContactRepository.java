package com.shritej.springsec.repository;

import com.shritej.springsec.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact , String> {


}
