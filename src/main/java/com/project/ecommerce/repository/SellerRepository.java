package com.project.ecommerce.repository;

import com.project.ecommerce.model.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

public interface SellerRepository extends MongoRepository<Seller, String> {
    Seller findByEmailAndPassword(String email, String password);
}
