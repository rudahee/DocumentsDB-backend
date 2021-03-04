package com.docdb.service.util.dto.converters;

import org.springframework.stereotype.Service;

import com.docdb.model.entity.Customer;
import com.docdb.model.entity.dto.CustomerDTO;
import com.docdb.service.util.dto.DTOConverter;

@Service
public class CustomerConverter extends DTOConverter<Customer, CustomerDTO> {

	@Override
	public Customer fromDto(CustomerDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO fromEntity(Customer entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
