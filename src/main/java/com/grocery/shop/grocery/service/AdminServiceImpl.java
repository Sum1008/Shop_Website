package com.grocery.shop.grocery.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.shop.grocery.entity.Admin;
import com.grocery.shop.grocery.repository.AdminRepository;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin validateAdmin(String email, String password) {
		if (email != null && password != null) {
			return adminRepository.checkAdminLogin(email, password);
		}
		return null;
	}

	@Override
	public Admin getAdminByEmail(String email) {
		return adminRepository.findAdminByEmail(email);
	}

	@Override
	public Optional<Admin> getByAdminId(Long id) 
	{
		return adminRepository.findById(id);
	}

	@Override
	public int changePassword(String password, String email)
	{
		return adminRepository.changePassword(password, email);
	}

	@Override
	public void updateAdminByEmail(String name, String email, Long id) {
		adminRepository.updateAdmin(name, email, id);	
	}
}