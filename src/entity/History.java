/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.sun.security.ntlm.Client;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Melnikov
 */
public class History implements Serializable{
    private Product product;
    private Buyer buyer;
    private Date giveProductToBuyerDate;
    private Date returnProduct;
    private int  quantity;

    public History() {
    }

public History(Product product, Buyer buyer, Date giveProductToBuyerDate, Date returnProduct, int quantity) {
    this.product = product;
    this.buyer = buyer;
    this.giveProductToBuyerDate = giveProductToBuyerDate;
    this.returnProduct = returnProduct;
    this.quantity = quantity;
}


    public int getQuantity() {
        return quantity;
    }
    
    public Date getReturnProduct() {
        return returnProduct;
    }

    public void setReturnProduct(Date returnProduct) {
        this.returnProduct = returnProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Date getGiveProductToBuyerDate() {
        return giveProductToBuyerDate;
    }

    public void setGiveProductToBuyerDate(Date giveProductToBuyerDate) {
        this.giveProductToBuyerDate = giveProductToBuyerDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.product);
        hash = 17 * hash + Objects.hashCode(this.buyer);
        hash = 17 * hash + Objects.hashCode(this.giveProductToBuyerDate);
        hash = 17 * hash + Objects.hashCode(this.returnProduct);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final History other = (History) obj;
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.buyer, other.buyer)) {
            return false;
        }
        if (!Objects.equals(this.giveProductToBuyerDate, other.giveProductToBuyerDate)) {
            return false;
        }
        if (!Objects.equals(this.returnProduct, other.returnProduct)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "History{" 
                + "product=" + product.getTitle()
                + ", buyer=" + buyer.getFirstname()
                + " " + buyer.getLastname()
                + ", giveproductTobuyerDate=" + giveProductToBuyerDate 
                + ", returnproduct=" + returnProduct 
                + ", Quantity=" + quantity
                + '}';
    }

    public Client getClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
