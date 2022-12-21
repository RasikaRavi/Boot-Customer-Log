package com.example.customerlog.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.customerlog.entity.Customer;
import com.example.customerlog.repo.Repository;


@Controller
public class CustomerController {

	@Autowired
	Repository repo;
	
	@RequestMapping("/checkin")
	@ResponseBody
	public List<Customer> checkinCust(@RequestParam String name)
	{
		Customer cust=new Customer();
		LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        String date=localDate.toString();
        String time=localTime.toString();
		cust.setName(name);
		cust.setLogtype("IN");
		cust.setDate(date);
		cust.setTime(time);
		repo.save(cust);
		
		return repo.displayCust(name);
	}
	
	@RequestMapping("/checkout")
	@ResponseBody
	public List<Customer> checkoutCust(@RequestParam String name)
	{
		Customer cust=new Customer();
		LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        String date=localDate.toString();
        String time=localTime.toString();
		cust.setName(name);
		cust.setLogtype("OUT");
		cust.setDate(date);
		cust.setTime(time);
		repo.save(cust);
		
		return repo.displayCust(name);
	}
	
	@RequestMapping("/getLog")
	@ResponseBody
	public List<Customer> getlogCust(@RequestParam String date)
	{
		return repo.getByDate(date);
	}
	
	@RequestMapping("/getAllLog")
	@ResponseBody
	public List<Customer> getAllLogCust()
	{
		return repo.findAll();
	}

	
}
