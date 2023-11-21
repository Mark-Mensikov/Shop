/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Product;
import entity.History;
import entity.Buyer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Melnikov
 */
public class SaveManager {
    private final String PRODUCT_FILENAME = "products";
    private final String BUYER_FILENAME = "buyers";
    private final String HISTORIES_FILENAME = "histories";
    public void saveProducts(List<Product> products){
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(PRODUCT_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        }
        
    }
    public List<Product> loadProducts(){
        List<Product> products = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(PRODUCT_FILENAME);
            ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return products;
    }
    public void saveBuyers(List<Buyer> buyers){
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(BUYER_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(buyers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        }
        
    }
    public List<Buyer> loadBuyers(){
        List<Buyer> buyers = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(BUYER_FILENAME);
            ois = new ObjectInputStream(fis);
            buyers = (List<Buyer>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return buyers;
    }
    public void saveHistories(List<History> histories){
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(HISTORIES_FILENAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(histories);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        }
        
    }
    public List<History> loadHistories(){
        List<History> histories = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(HISTORIES_FILENAME);
            ois = new ObjectInputStream(fis);
            histories = (List<History>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not fount");
        } catch (IOException ex) {
            System.out.println("I/O error");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        return histories;
    }
}
