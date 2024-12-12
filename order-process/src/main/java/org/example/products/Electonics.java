package org.example.products;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Electonics extends Product{
    private String  powerSupply;
    @Override
    public String toString() {
        return super.toString()+"PowerSupply:"+powerSupply;
    }
}