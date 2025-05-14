package com.project.ecommerce.repository;

import com.project.ecommerce.model.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepository extends MongoRepository<Seller, String> {
    Seller findByEmailAndPassword(String email, String password);
}
