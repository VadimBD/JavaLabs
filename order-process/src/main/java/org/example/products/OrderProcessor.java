package org.example.products;

import java.util.List;

public class OrderProcessor <T extends Product>{
    private T product;
    public OrderProcessor (T product) {
        this.product = product;
    }
    public void process () {
        System.out.println ("Processing order for: " + product);
    }
    public String getProductClassName () {
        return product.ClassName();
    }

}
