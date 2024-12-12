package org.example.products;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Clothing extends Product {
    private String size;
    private String gender;
    @Override
    public String toString() {
        return  super.toString()+"size:"+size+" "+"gender:"+gender;
    }
}