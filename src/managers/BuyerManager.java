/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Buyer;
import java.util.List;
import java.util.Scanner;
import tools.InputFromKeyboard;

/**
 *
 * @author Melnikov
 */
public class BuyerManager {

    private final Scanner scanner;

    public BuyerManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public Buyer addBuyer() {
        System.out.println(" ----- Add new buyer -----");
        Buyer reader = new Buyer();
        System.out.print("Firstname: ");
        reader.setFirstname(scanner.nextLine());
        System.out.print("Lastname: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Phone: ");
        reader.setPhone(scanner.nextLine());
        System.out.print("money: ");
        reader.setMoney(scanner.nextDouble());scanner.nextLine();
        System.out.println("Added buyer " + reader.toString());
        return reader;
    }

    public int pirntListBuyers(List<Buyer> buyers) {
        int count = 0;
        System.out.println("List buyers: ");
        for (int i = 0; i < buyers.size(); i++) {
            System.out.printf("%d. %s. %s. %s %s€%n",
                    i+1,
                    buyers.get(i).getFirstname(),
                    buyers.get(i).getLastname(),
                    buyers.get(i).getPhone(),
                    buyers.get(i).getMoney()
            );
            count++;
        }
        return count;
    }
    public void addMoneyToBuyer(List<Buyer> buyers) {
    this.pirntListBuyers(buyers);
    System.out.println("Enter number of buyer to add money");
    int buyerNumber = InputFromKeyboard.inputNumberFromRange(1, buyers.size());
    System.out.println("how much money do you want to add?: ");
    double copyNumber = InputFromKeyboard.inputNumberFromRange(0, 1000);
    buyers.get(buyerNumber-1).setMoney(buyers.get(buyerNumber-1).getMoney()+copyNumber);
    }
    
    
}
