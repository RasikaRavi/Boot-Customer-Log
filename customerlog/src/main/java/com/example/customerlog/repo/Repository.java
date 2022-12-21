package com.example.customerlog.repo;

import com.example.customerlog.entity.Customer;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repository extends JpaRepository<Customer, Integer>  {
	
	@Query(value = "SELECT * FROM Customer WHERE name=?1", nativeQuery = true)
	List<Customer> displayCust(String name);
	
	@Query(value = "SELECT * FROM Customer WHERE date=?1", nativeQuery = true)
	List<Customer> getByDate(String date);
}
