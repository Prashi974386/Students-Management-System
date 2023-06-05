package com.ty.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.studentmanagementsystem.dto.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
