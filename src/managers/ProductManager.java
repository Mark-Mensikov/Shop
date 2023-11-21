/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;


import entity.Product;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import tools.InputFromKeyboard;

/**
 *
 * @author Melnikov
 */
public class ProductManager {

    private final Scanner scanner;

    public ProductManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public Product addProduct() {
        System.out.println("----- Add new product -----");
        Product product;
        product = new Product();
        System.out.print("Enter title: ");
        product.setTitle(scanner.nextLine());
        System.out.println("Enter product price: ");
        product.setPrice(scanner.nextDouble());scanner.nextLine();

        System.out.print("Enter quantity copy: ");
        product.setQuantity(InputFromKeyboard.inputNumberFromRange(1, 100));
        product.setCount(product.getQuantity());
        System.out.println("Added product: "+product.toString());
        return product;
    }

    public int pirntListProducts(List<Product> products) {
        int count = 0;
        System.out.println("List products: ");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf(" %s. %s. %s€ In stock: %d%n",
                    i+1,
                    products.get(i).getTitle(),
                    products.get(i).getPrice(),
                    products.get(i).getCount()
            );
            count++;
        }
        return count;
    }
    
}
