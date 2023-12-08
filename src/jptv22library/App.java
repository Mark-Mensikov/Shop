/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv22library;

import entity.History;
import managers.HistoryManager;
import entity.Product;
import entity.Buyer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import managers.ProductManager;
import managers.BuyerManager;
import java.util.Scanner;
import managers.SaveManager;
import tools.InputFromKeyboard;

/**
 *
 * @author Melnikov
 */
public class App {
    private final Scanner scanner;
    private List<Product> products;
    private List<Buyer> buyers;
    private List<History> histories;
    private final ProductManager productManager;
    private final BuyerManager buyerManager;
    private HistoryManager historyManager;
    private SaveManager saveManager;
    
    public App() {
        this.scanner = new Scanner(System.in);
        this.saveManager = new SaveManager();
        this.products = saveManager.loadProducts();
        this.buyers = saveManager.loadBuyers();
        this.histories = saveManager.loadHistories();
        this.productManager = new ProductManager(scanner);
        this.buyerManager = new BuyerManager(scanner);
        this.historyManager = new HistoryManager(scanner);
    }

    void run() {
        boolean repeat = true;
        System.out.println("------ Shop ------");
        do{
            System.out.println("List tasks:");
            System.out.println("0. Exit");
            System.out.println("1. Add new product");
            System.out.println("2. Add new client");
            System.out.println("3. Print list products");
            System.out.println("4. Print list clients");
            System.out.println("5. Purchase the product to the client");
            System.out.println("6. Print list purchased products");
            System.out.println("7. Display the total cost of all goods sold.");
            System.out.println("8. Add money to the buyer");
            System.out.println("9. Customer rating by number of purchases");
            System.out.println("11. Editing the product");
            System.out.println("12. Editing a user");
            System.out.println("13. Black Friday");
            
            System.out.print("Enter number task: ");
            int task = InputFromKeyboard.inputNumberFromRange(0,13);
            System.out.printf("Selected task %d, continue? (y/n): ",task);
            String continueRun = InputFromKeyboard.inputSymbolYesOrNo();
            if(continueRun.equals("n")){
                continue;
            }
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    products.add(productManager.addProduct());
                    saveManager.saveProducts(this.products);//save to file
                    break;
                case 2:
                    buyers.add(buyerManager.addBuyer());
                    saveManager.saveBuyers(buyers);
                    break;
                case 3:
                    productManager.pirntListProducts(products);
                    break;
                case 4:
                    buyerManager.pirntListBuyers(buyers);
                    break;
                case 5:
                    History history = historyManager.giveProductToBuyer(buyers, products);
                    if(history != null){
                        this.histories.add(history);
                        saveManager.saveHistories(histories);
                    }
                    break;
                case 6:
                    historyManager.printListBuyingProducts(histories);
                    break;
                case 7:
                    historyManager.displayTotalCost();
                    break;
                case 8:
                    buyerManager.addMoneyToBuyer(buyers);
                    break;
                case 9:
                    historyManager.CustomerRatingByNumberOfPurchases(this.histories);
                    break;
                case 10:
                    historyManager.ProductSalesRating(this.histories);
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    historyManager.BlackFriday(this.histories);
                    break;
                default:
                    System.out.println("Select number from list tasks!");
            }
            System.out.println("-------------------------");
        }while(repeat);
    }

    
}
