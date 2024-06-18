package com.grocery.shop.grocery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.shop.grocery.entity.Customer;

public interface UserAdmRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findById(Long pid);

    List<Customer> findAll();

    void deleteById(Long pid);

}
