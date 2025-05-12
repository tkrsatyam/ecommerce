package com.project.ecommerce.service;

import com.project.ecommerce.bean.ProductBean;
import com.project.ecommerce.model.Product;
import com.project.ecommerce.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductBean add(ProductBean productBean) {
        Product product = new Product();
        BeanUtils.copyProperties(productBean, product);
        product = productRepository.save(product);
        ProductBean saved = new ProductBean();
        BeanUtils.copyProperties(product, saved);
        return saved;
    }

    public List<ProductBean> showAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductBean> allProducts = new ArrayList<ProductBean>();
        for(Product product : productList) {
            ProductBean productBean = new ProductBean();
            BeanUtils.copyProperties(product, productBean);
            allProducts.add(productBean);
        }
        return allProducts;
    }

//    public ResponseEntity<String> delete(String id) {
//        productRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
}
