package com.shiva.productrepository;

import org.springframework.data.repository.CrudRepository;

import com.shiva.productentity.Product;

public interface ProductDAO extends CrudRepository<Product, Integer>{

}
