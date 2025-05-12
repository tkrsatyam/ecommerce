package com.project.ecommerce.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerBean {
    private String id;
    private String email;
    private String name;
    private String password;
}
