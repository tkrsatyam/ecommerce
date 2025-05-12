package com.project.ecommerce.controller;

import com.project.ecommerce.bean.ProductBean;
import com.project.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductBean> addProductBean(@RequestBody ProductBean product) {
        return ResponseEntity.ok(productService.add(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductBean>> showAllProductBeans() {
        return ResponseEntity.ok(productService.showAll());
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteProductBean(@PathVariable String id) {
//        return productService.delete(id);
//    }
}
