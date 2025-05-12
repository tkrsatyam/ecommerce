package com.project.ecommerce.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductBean {
    private String id;
    private String name;
    private Integer price;
    private String category;
    private String color;
    private String description;
    private String image;
}
