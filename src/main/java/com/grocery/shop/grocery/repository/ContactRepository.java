package com.grocery.shop.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.shop.grocery.entity.Contact;



public interface ContactRepository extends JpaRepository<Contact, Long> {

}