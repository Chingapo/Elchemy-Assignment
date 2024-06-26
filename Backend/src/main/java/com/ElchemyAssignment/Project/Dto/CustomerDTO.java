package com.ElchemyAssignment.Project.Dto;

public class CustomerDTO {

	private int customerid;
	private String customername;
	private String email;
	private String password;

	public CustomerDTO(int customerid, String customername, String email, String password) {
		this.customerid = customerid;
		this.customername = customername;
		this.email = email;
		this.password = password;
	}


	public CustomerDTO() {
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CustomerDTO{" +
				"customerid=" + customerid +
				", customername='" + customername + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
