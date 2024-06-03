package com.shiva.orderrepository;

import org.springframework.data.repository.CrudRepository;

import com.shiva.orderentity.Order;

public interface OrderDAO extends CrudRepository<Order, Integer>{

	
}
