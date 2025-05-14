package com.project.ecommerce.controller;

import com.project.ecommerce.bean.ProductBean;
import com.project.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<List<ProductBean>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) Integer size
    ) {

        List<ProductBean> products;
        if (size == null) {
            products = productService.getAll();
        } else {
            products = productService.getAll(page, size);
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showProductById(@PathVariable String id) {
        ProductBean foundProduct = productService.getById(id);
        if (foundProduct == null) {
            return ResponseEntity
                    .status(404)
                    .body(Map.of("error", "Product not found with id: " + id));
        }
        return ResponseEntity.ok(foundProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody ProductBean productBean) {
        ProductBean updatedProduct = productService.update(id, productBean);

        if (updatedProduct == null) {
            return ResponseEntity.status(404).body(Map.of("error", "Product not found with id: " + id));
        }

        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductBean(@PathVariable String id) {
        ProductBean deletedProduct = productService.delete(id);

        if (deletedProduct == null) {
            return ResponseEntity
                    .status(404)
                    .body(Map.of("error", "Product not found with id: " + id));
        }

        return ResponseEntity
                .ok(Map.of("message", "Product deleted successfully", "deletedProduct", deletedProduct));
    }

}
