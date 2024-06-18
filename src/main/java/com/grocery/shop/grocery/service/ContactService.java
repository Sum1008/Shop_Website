package com.grocery.shop.grocery.service;

import com.grocery.shop.grocery.entity.Contact;

import jakarta.mail.MessagingException;

public interface ContactService {
	
	void saveContacts(Contact contact) throws MessagingException;

}