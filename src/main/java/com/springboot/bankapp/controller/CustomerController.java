package com.springboot.bankapp.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankapp.model.Customer;
import com.springboot.bankapp.model.UserInfo;
import com.springboot.bankapp.service.CustomerService;

@RestController
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	 
	@PostMapping("/customer")
	public Customer postCustomer(@RequestBody Customer customer) {
		System.out.println(customer);
		return customerService.postCustomer(customer);
	}
	
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);  
	}
	
	@GetMapping("/user")
	public UserInfo getUser(Principal principal) {
		UserInfo user = customerService.getUserByName(principal.getName());
		return user; 
	}
//	@PutMapping("/accountStting")
//	public Customer updateAccountDetails() {
//		return customerService.updateAccountDetails(customer);
//	}
	
	@GetMapping("/customer/{id}")
	public Customer findByid(Principal principal,@PathVariable("id") Long id) {
		return customerService.findByid(id); 		
	}
	
	@PutMapping("/customer/{id}/{address}/{city}")
	public void updateCustomer(Principal principal,@PathVariable("id") Long id, @PathVariable("address") String address,
			@PathVariable("city") String city) {
	customerService.updateCustomer(address,city,id);
	
	}
//	@GetMapping("/customer/{id}/{address}/{city}")
//	public void getCustomer(Principal principal,@PathVariable("id") Long id, @PathVariable("address") String address,
//			@PathVariable("city") String city) {
//	customerService.getCustomer(address,city,id);
//	
//	}
}