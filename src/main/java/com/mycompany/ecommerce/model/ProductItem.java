
package com.mycompany.ecommerce.model;

/**
 *
 * @author samah
 */
public class ProductItem {
    
    
    private int id ;
    private String name;
    private double price;
    
    
    
    public ProductItem() {
    }
    
    
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    
}
