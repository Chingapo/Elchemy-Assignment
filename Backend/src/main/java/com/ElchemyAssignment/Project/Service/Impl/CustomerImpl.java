package com.ElchemyAssignment.Project.Service.Impl;

import com.ElchemyAssignment.Project.Dto.CustomerDTO;
import com.ElchemyAssignment.Project.Dto.LoginDTO;
import com.ElchemyAssignment.Project.Entity.Customer;
import com.ElchemyAssignment.Project.Repository.CustomerRepo;
import com.ElchemyAssignment.Project.Service.CustomerService;
import com.ElchemyAssignment.Project.payloadResponse.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addCustomer(CustomerDTO customerDTO) {

		Customer customer = new Customer(
				customerDTO.getCustomerid(),
				customerDTO.getCustomername(),
				customerDTO.getEmail(),

				this.passwordEncoder.encode(customerDTO.getPassword())
		);

		customerRepo.save(customer);
		return customer.getCustomername();

	}

	@Override
	public LoginResponse loginCustomer(LoginDTO loginDTO) {
		String msg = "";
		Customer customer1 = customerRepo.findByEmail(loginDTO.getEmail());
		if (customer1 != null) {
			String password = loginDTO.getPassword();
			String encodedPassword = customer1.getPassword();
			Boolean match = passwordEncoder.matches(password, encodedPassword);
			if (match) {
				Optional<Customer> customer = customerRepo.findByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
				if(customer.isPresent()) {
					return new LoginResponse("Login Success", true);
				} else {
					return new LoginResponse("Login Failed", false);
				}
			} else {
				return new LoginResponse("Wrong Password", false);
			}
		} else {
			return new LoginResponse("Wrong Email", false);
		}

	}
}
