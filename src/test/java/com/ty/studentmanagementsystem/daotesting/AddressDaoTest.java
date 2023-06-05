package com.ty.studentmanagementsystem.daotesting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.studentmanagementsystem.dto.Address;
import com.ty.studentmanagementsystem.repository.AddressRepository;

@SpringBootTest
public class AddressDaoTest {
	@Autowired
	AddressRepository repository;

	@Test
	public void saveAddress() {
		Address address = Address.builder()
				.area("btm")
				.district("bng")
				.state("kar")
				.pincode(566712)
				.build();
		
		repository.save(address);
		
		Assertions.assertThat(address.getId()).isGreaterThan(0);
	}

	@Test
	public void updateAddress() {
		Address address = Address.builder()
				.area("btm")
				.district("bng")
				.state("kar")
				.pincode(566712)
				.addressType("current")
				.id(2)
				.build();

		repository.save(address);

		Assertions.assertThat(address.getAddressType()).isEqualTo("current");
	}
}
