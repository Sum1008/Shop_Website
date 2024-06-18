package com.grocery.shop.grocery.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.shop.grocery.entity.Contact;
import com.grocery.shop.grocery.repository.ContactAdmRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ContactAdmServiceImpl implements ContactAdmService
{
	@Autowired
	ContactAdmRepository contactAdmRepo;
	
	@Override
	public Optional<Contact> getContactId(Long pid)
	{
		
		return contactAdmRepo.findById(pid);
	}

	@Override
	public List<Contact> getAllContact() 
	{
		
		return contactAdmRepo.findAll();
	}

	@Override
	public void deleteContact(Long pid) 
	{
		contactAdmRepo.deleteById(pid);
	}

	@Override
	public void deleteAll(List<Contact> ids)
	{
		contactAdmRepo.deleteInBatch(ids);
	}

}