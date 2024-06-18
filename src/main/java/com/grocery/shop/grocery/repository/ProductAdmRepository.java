package com.grocery.shop.grocery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.shop.grocery.entity.Product;

public interface ProductAdmRepository extends JpaRepository<Product, Long>{

    Product save(Product product);

    Optional<Product> findById(Long pid);

    List<Product> findAll();

    void deleteById(Long pid);

    //Long count();

}
