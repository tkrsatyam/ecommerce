package com.project.ecommerce.service;

import com.project.ecommerce.bean.SellerBean;
import com.project.ecommerce.model.Seller;
import com.project.ecommerce.repository.SellerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public SellerBean signUp(SellerBean sellerBean) {
        Seller seller = new Seller();
        BeanUtils.copyProperties(sellerBean, seller);
        seller = this.sellerRepository.save(seller);
        SellerBean saved = new SellerBean();
        BeanUtils.copyProperties(seller, saved);
        return saved;
    }

    public SellerBean login(String email, String password) {
        Seller seller = this.sellerRepository.findByEmailAndPassword(email, password);
        if (seller == null) {
            return null;
        }
        SellerBean found = new SellerBean();
        BeanUtils.copyProperties(seller, found);
        return found;
    }
}
