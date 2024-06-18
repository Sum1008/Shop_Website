package com.grocery.shop.grocery.service;

import java.util.List;
import java.util.Optional;

import com.grocery.shop.grocery.entity.Customer;

public interface UserAdmService
{
	public Optional<Customer> getCustomerId(Long pid);
	public List<Customer> getAllCustomer();
	public void deleteCustomer(Long pid);
	public void deleteAll(List<Customer> ids);
}
