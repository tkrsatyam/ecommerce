package com.project.ecommerce.service;

import com.project.ecommerce.bean.ProductBean;
import com.project.ecommerce.model.Product;
import com.project.ecommerce.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public List<ProductBean> getAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductBean> allProducts = new ArrayList<>();

        for (Product product : productList) {
            ProductBean bean = new ProductBean();
            BeanUtils.copyProperties(product, bean);
            allProducts.add(bean);
        }

        return allProducts;
    }

    public List<ProductBean> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);

        List<ProductBean> productList = new ArrayList<>();
        for (Product product : productPage.getContent()) {
            ProductBean bean = new ProductBean();
            BeanUtils.copyProperties(product, bean);
            productList.add(bean);
        }

        return productList;
    }

    public ProductBean getById(String id) {
        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return null;
        }
        ProductBean found = new ProductBean();
        BeanUtils.copyProperties(product, found);
        return found;
    }

    public ProductBean update(String id, ProductBean productBean) {
        Product found = productRepository.findById(id).orElse(null);
        if (found == null) {
            return null;
        }

        found.setCategory(productBean.getCategory());
        found.setName(productBean.getName());
        found.setColor(productBean.getColor());
        found.setImage(productBean.getImage());
        found.setDescription(productBean.getDescription());
        found.setPrice(productBean.getPrice());

        Product saved = productRepository.save(found);
        ProductBean updated = new ProductBean();
        BeanUtils.copyProperties(saved, updated);
        return updated;
    }


    public ProductBean delete(String id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null;
        }
        productRepository.deleteById(id);
        ProductBean deleted = new ProductBean();
        BeanUtils.copyProperties(product, deleted);
        return deleted;
    }

}
