package com.project.ecommerce.controller;

import com.project.ecommerce.bean.SellerBean;
import com.project.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public ResponseEntity<SellerBean> sellerSignUp(@RequestBody SellerBean seller) {
        return ResponseEntity.ok(sellerService.signUp(seller));
    }

    @GetMapping
    public ResponseEntity<?> sellerLogin(@RequestParam String email, @RequestParam String password) {
        SellerBean seller = sellerService.login(email, password);
        if (seller == null) {
            return ResponseEntity
                    .status(401)
                    .body(Map.of("error", "Invalid email or password"));
        }
        return ResponseEntity.ok(seller);
    }

}
