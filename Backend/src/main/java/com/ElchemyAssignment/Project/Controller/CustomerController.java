package com.ElchemyAssignment.Project.Controller;

import com.ElchemyAssignment.Project.Dto.CustomerDTO;
import com.ElchemyAssignment.Project.Dto.LoginDTO;
import com.ElchemyAssignment.Project.Service.CustomerService;
import com.ElchemyAssignment.Project.payloadResponse.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/save")
	public String saveCustomer(@RequestBody @Validated CustomerDTO customerDTO) {
		String id = customerService.addCustomer(customerDTO);
		return id;
	}

	@PostMapping(path = "/login")
	public ResponseEntity<?> loginCustomer(@RequestBody @Validated LoginDTO loginDTO) {
		LoginResponse loginResponse = customerService.loginCustomer(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}
}
