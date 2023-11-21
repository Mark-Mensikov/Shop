/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Melnikov
 */
public class Product implements Serializable{
    private String title;
    private Double price;
    private int quantity; //Всего закупленных в библиотеку экземпляров
    private int count; //экземпляров в наличии.

    public Product() {
    }

    public Product(String title, int quantity, int count, double price) {
        this.title = title;
        this.quantity = quantity;
        this.count = count;
        this.price = price;
    }

    
    @Override
    public String toString() {
        return "Book{" 
                + "title=" + title 
                + ", quantity=" + quantity
                + ", count=" + count
                + ", price=" + price
                + '}';
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + this.quantity;
        hash = 53 * hash + this.count;
        hash = (int) (double) (53 * hash + this.price);
        return hash;
    }
    
    
}
