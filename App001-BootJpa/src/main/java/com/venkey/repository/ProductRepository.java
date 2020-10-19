package com.venkey.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.venkey.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

}
