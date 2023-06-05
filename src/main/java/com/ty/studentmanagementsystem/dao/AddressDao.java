package com.ty.studentmanagementsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.studentmanagementsystem.dto.Address;
import com.ty.studentmanagementsystem.repository.AddressRepository;

@Repository
public class AddressDao {
	@Autowired
	AddressRepository repository;
	
	public Address saveAddress(Address address) {
		return repository.save(address);
	}
	
	public Address updateAddress(Address address) {
		 Optional<Address> optional = repository.findById(address.getId());
		 if(optional.isPresent()) {
			 return repository.save(address);
		 }
		 return null;
	}
}
