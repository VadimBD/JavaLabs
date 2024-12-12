package org.example.products;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public  class Product {
    private int id;
    private String name;
    private String brand;
    private String price;
    public String ClassName() {
        return getClass().getSimpleName();
    }
}