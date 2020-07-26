package com.ecommerce.product.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.product.management.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>  {

}
