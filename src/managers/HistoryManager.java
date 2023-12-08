/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import com.sun.security.ntlm.Client;
import entity.Product;
import entity.History;
import entity.Buyer;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
import tools.InputFromKeyboard;

/**
 *
 * @author Melnikov
 */
public class HistoryManager {

    private final Scanner scanner;
    private final BuyerManager buyerManager;
    private final ProductManager productManager;
    private double totalCost;

    public HistoryManager(Scanner scanner) {
        this.scanner = scanner;
        this.buyerManager = new BuyerManager(scanner);
        this.productManager = new ProductManager(scanner);
       
    }
        /**
         * Логика выдачи продукта покупателю
         * 1. Выводим нумерованный список покупателей
         * 2. Просим ввести номер покупателя
         * 3. получим по индексу покупателя из массива покупателей
         * 4. инициируем поле в history.setBuyer(buyer)
         * 5-9. Повторить действия 1-4 с продуктом
         * Если количество продуктов в наличии больше чем количество экземпляров этого продукта
         * 10. инициируем дату выдачи продукта текущим временем
         * 11. Уменьшаем количество продукта в наличии на 1
         * 12. Возвращаем новую History
         * 13. иначе возвращаем null
         * 14. вычитание money у buyer через price у product
         * 15. проверка что-бы хватало денег
         */
    public History giveProductToBuyer(List<Buyer> buyers, List<Product> products) {
        System.out.println("------------- Give the product to the buyer ----------------");
        History history = new History();
       
        int countBuyersInList = buyerManager.pirntListBuyers(buyers);
        System.out.print("Enter number of buyer: ");
        int buyerNumber = InputFromKeyboard.inputNumberFromRange(1, countBuyersInList);
        history.setBuyer(buyers.get(buyerNumber-1));

        int countProductsInList = productManager.pirntListProducts(products);
        System.out.print("Enter number of product: ");
        int productNumber = InputFromKeyboard.inputNumberFromRange(1, countProductsInList);
        if (products.get(productNumber - 1).getCount() > 0) {
            System.out.print("Enter the number of products you want to buy: ");
            int quantityToBuy = InputFromKeyboard.inputNumberFromRange(1, products.get(productNumber - 1).getCount());

    if (quantityToBuy > 0 && quantityToBuy <= products.get(productNumber - 1).getCount()) {
        // Проверяем, хватает ли у покупателя денег
        if (buyers.get(buyerNumber - 1).getMoney() >= (products.get(productNumber - 1).getPrice() * quantityToBuy)) {
            // Устанавливаем выбранный продукт в историю
            history.setProduct(products.get(productNumber - 1));
            // Уменьшаем количество продуктов на складе
            products.get(productNumber - 1).setCount(products.get(productNumber - 1).getCount() - quantityToBuy);
            // Устанавливаем дату выдачи продукта
            history.setGiveProductToBuyerDate(new GregorianCalendar().getTime());

            // Вычитаем стоимость продукта из баланса покупателя
            double purchasePrice = products.get(productNumber - 1).getPrice() * quantityToBuy;
            buyers.get(buyerNumber - 1).setMoney(buyers.get(buyerNumber - 1).getMoney() - purchasePrice);
            
            // Обновляем totalCost
            totalCost += purchasePrice;
        return history;
        } else {
            System.out.println("The buyer does not have enough funds to purchase the specified number of products.");
            return null;
        }
    } else {
        System.out.println("Invalid number of products.");
        return null;
    }
} else {
    System.out.println("Все продукты уже куплены");
    return null;
}
}
    public  int printListBuyingProducts(List<History> histories) {
        int countBuyedProducts = 0;
        System.out.println("List buyed products:");
        for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i).getReturnProduct() == null){
                System.out.printf("%d. %s. buyed %s products for %s€ by %s %s%n",
                        i+1,
                        histories.get(i).getProduct().getTitle(),
                        histories.get(i).getProduct().getQuantity()-
                        histories.get(i).getProduct().getCount(),
                        histories.get(i).getProduct().getPrice(),
                        histories.get(i).getBuyer().getFirstname(),
                        histories.get(i).getBuyer().getLastname()
                        
                );
                countBuyedProducts++;
            }
        }
        if(countBuyedProducts < 1){
            System.out.println("\tNo products to buy");
        }
        return countBuyedProducts;
    }
    public double getTotalCostOfAllPurchasedProducts(List<History> histories) {
        double totalCost = 0.0;
        for (History history : histories) {
            Product product = history.getProduct();
            if (product != null && history.getReturnProduct() == null) {
                // Обновляем totalCost
                totalCost += (product.getPrice() * history.getQuantity());
            }
        }
        return totalCost;
    }
    
    public void displayTotalCost() {
        System.out.println("Total cost of all goods sold: " + totalCost + "€");
    }

    public void ProductSalesRating(List<History> histories) {
         Map<Product,Integer> mapProducts = new HashMap<>();
        for (int i = 0; i < histories.size(); i++) {
            Product product = histories.get(i).getProduct();
            if(mapProducts.containsKey(product)){
                mapProducts.put(product,mapProducts.get(product) + 1);
            }else{
                mapProducts.put(product,1);
            }
        }
        Map<Product, Integer> sortedMap = mapProducts.entrySet()
            .stream()
            .sorted(Map.Entry.<Product, Integer>comparingByValue().reversed())
            .collect(Collectors.toMap(
                Map.Entry::getKey, 
                Map.Entry::getValue, 
                (oldValue, newValue) -> oldValue, 
                LinkedHashMap::new));
        System.out.println("Ranking of products being buy:");
        int n=1;
        for (Map.Entry entry : sortedMap.entrySet()) {
            System.out.printf("%d. %s: %d%n",
                    n,
                    ((Product)entry.getKey()).getTitle(),
                    entry.getValue()
            );
            n++;
    }
}

    public void CustomerRatingByNumberOfPurchases(List<History> histories) {
        Map<Buyer,Integer> mapBuyers = new HashMap<>();
        for (int i = 0; i < histories.size(); i++) {
            Buyer buyer = histories.get(i).getBuyer();
            if(mapBuyers.containsKey(buyer)){
                mapBuyers.put(buyer,mapBuyers.get(buyer) + 1);
            }else{
                mapBuyers.put(buyer,1);
            }
        }
        System.out.println("Ranking of buyers being buyer:");
        int n = 1;
        for (Map.Entry entry : mapBuyers.entrySet()) {
            System.out.printf("%d. %s: %d%n",
                    n,
                    ((Buyer)entry.getKey()),
                    entry.getValue()
            );
            n++; 
    }
}

    public void BlackFriday(List<History> histories) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime blackFriday = LocalDateTime.of(2023, 12, 15, 0, 0, 0);
        long days = now.until(blackFriday, ChronoUnit.DAYS);
        long hours = now.until(blackFriday, ChronoUnit.HOURS) % 24;
        long minutes = now.until(blackFriday, ChronoUnit.MINUTES) % 60;
        long seconds = now.until(blackFriday, ChronoUnit.SECONDS) % 60;
        System.out.printf("До черной пятницы 15.12.23 осталось %d дней, %d часов, %d минут, %d секунд.", days, hours, minutes, seconds);

    }
}