/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Melnikov
 */
public class Buyer implements Serializable{
    private String firstname;
    private String lastname;
    private String phone;
    private Double money;

    public Buyer() {
    }

    public Buyer(String firstname, String lastname, String phone, Double money) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.money = money;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.firstname);
        hash = 79 * hash + Objects.hashCode(this.lastname);
        hash = 79 * hash + Objects.hashCode(this.phone);
        hash = 79 * hash + Objects.hashCode(this.phone);
        hash = 79 * hash + Objects.hashCode(this.money);
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
        final Buyer other = (Buyer) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.money, other.money)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Buyer{" 
                + "firstname=" + firstname 
                + ", lastname=" + lastname 
                + ", phone=" + phone 
                + ", money=" + money 
                + '}';
    }

    public void setmoney(double nextDouble) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
