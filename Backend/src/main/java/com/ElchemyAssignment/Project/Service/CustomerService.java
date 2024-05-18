package com.ElchemyAssignment.Project.Service;

import com.ElchemyAssignment.Project.Dto.CustomerDTO;
import com.ElchemyAssignment.Project.Dto.LoginDTO;
import com.ElchemyAssignment.Project.Entity.Customer;
import com.ElchemyAssignment.Project.payloadResponse.LoginResponse;

public interface CustomerService {
	String addCustomer(CustomerDTO customerDTO);

	LoginResponse loginCustomer(LoginDTO loginDTO);
}
