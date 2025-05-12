package com.project.ecommerce.controller;

import com.project.ecommerce.bean.SellerBean;
import com.project.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<SellerBean> sellerLogin(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(sellerService.login(email, password));
    }

}
