import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Receipt {

    // CREATE VARIABLES 
    private boolean isVeg;
    private boolean isPremium;
    private String pizzaName;
    private String pizzaSize; 
    private int quantity;
    private String topping = "No toppings";
    private double discountApplied = 0.0;
    private String couponCode = "None";
    private double costBeforeDiscount;

    // CONSTRUCTOR FOR ACCESSING PRIVATE VARIABLES
    public Receipt(boolean isVeg, boolean isPremium, String pizzaName, String pizzaSize, int quantity) {
        this.isVeg = isVeg;
        this.isPremium = isPremium;
        this.pizzaName = pizzaName;
        this.pizzaSize = pizzaSize; 
        this.quantity = quantity;
    }

    // METHOD TO ADD BASE COST
    public double getCost() {
        double cost = 0;

        // COST FOR PIZZA TYPE
        if (isVeg) {
            cost += 250; 
        } else {
            cost += 300; 
        }

        // ADDITIONAL COST FOR PREMIUM
        if (isPremium) {
            cost += 100; 
        }

        //ADDITIONAL COST UPON PIZZA SIZE
        if (pizzaSize.equalsIgnoreCase("Small")) {
            cost += 0; 
        } 
        else if (pizzaSize.equalsIgnoreCase("Medium")) {
            cost += 50; 
        } 
        else if (pizzaSize.equalsIgnoreCase("Large")) {
            cost += 100; 
        }
        return cost * quantity;  //MULTIPLE BY QUANTITY
    }

    // METHOD TO ADD TOPPINGS
    public double addToppings(double cost, String topping) {
        this.topping = topping;
        if (topping.equals("cheese")) {
            cost += 20;
        } 
        else if (topping.equals("chicken")) {
            cost += 50;
        } 
        else if (topping.equals("onion")) {
            cost += 15;
        }
        return cost;
    }

    // METHOD TO ADD TAX
    public double addTax(double cost) {
        return cost + cost * 0.05; // Adding 5% tax
    }

    // METHOD TO ADD DISCOUNT
    public double addDiscount(double cost, double discount) {
        discountApplied = discount; 
        return cost - (cost * discount); 
    }

    // FUNCTION TO PRINT THE RECEIPT WITH DETAILS
    public void printReceipt(double finalCost) {
        String receiptDetails = "\n****** Pizza Shop Receipt ******\n" +
                "\nPizza Name: " + pizzaName + "\n" +
                "Pizza Size: " + pizzaSize + "\n" +
                "Quantity: " + quantity + "\n" +
                "Pizza Type: " + (isVeg ? "Veg" : "Non-Veg") + "\n" +
                "Premium: " + (isPremium ? "Yes" : "No") + "\n" +
                "Toppings: " + topping + "\n" +
                "Discount Coupon: " + couponCode + "\n" +
                "Discount Applied: " + (discountApplied * 100) + "%\n" +
                "Cost before discount: " + costBeforeDiscount + "\n" +
                "Final Cost after tax: " + finalCost + "\n" +
                "\n****** Thank You! Visit Again ******\n";

        System.out.println(receiptDetails);

        // SAVE RECEIPT AS TEXT FILE
        try (FileWriter writer = new FileWriter("pizzareceipt.txt")) {
            writer.write(receiptDetails);
            System.out.println("Receipt saved to pizzareceipt.txt");
        } catch (IOException e) {
            System.out.println("Error while saving the receipt: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        
        // FUNCTIONALITY FOR PIZZA NAME SELECTION FROM OPTIONS
        System.out.println("\n****** Welcome to PIZZA shop! ******");
        System.out.println("\nChoose your pizza name: ");
        System.out.println("1. Margherita");
        System.out.println("2. Pepperoni");
        System.out.println("3. Veggie");
        System.out.println("4. BBQ");

        System.out.print("Enter the choice: ");
        int pizzaChoice = Integer.parseInt(System.console().readLine());
        String pizzaName = "";
        switch (pizzaChoice) {
            case 1:
                pizzaName = "Margherita";
                break;
            case 2:
                pizzaName = "Pepperoni";
                break;
            case 3:
                pizzaName = "Veggie";
                break;
            case 4:
                pizzaName = "BBQ";
                break;
            default:
                System.out.println("Invalid choice, defaulting to Margherita.");
                pizzaName = "Margherita";
        }

        // FUNCTIONALITY FOR PIZZA SIZE SELECTION FROM OPTIONS
        System.out.println("\nChoose your pizza size: ");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");

        System.out.print("Enter the choice: ");
        int sizeChoice = Integer.parseInt(System.console().readLine());
        String pizzaSize = "";
        switch (sizeChoice) {
            case 1:
                pizzaSize = "Small";
                break;
            case 2:
                pizzaSize = "Medium";
                break;
            case 3:
                pizzaSize = "Large";
                break;
            default:
                System.out.println("Invalid choice, defaulting to Small.");
                pizzaSize = "Small";
        }

        // FUNCTIONALITY FOR PIZZA QUANTITY
        System.out.print("\nEnter the quantity: ");
        int quantity = Integer.parseInt(System.console().readLine());

        // FUNCTIONALITY FOR VEG OR NON-VEG SELECTION
        System.out.println("\nSelect the pizza type: ");
        System.out.println("1. Veg");
        System.out.println("2. Non-Veg");

        System.out.print("Enter the choice: ");
        int choice = Integer.parseInt(System.console().readLine());
        boolean isVeg = false;
        if (choice == 1) {
            isVeg = true;
        }

        // FUNCTIONALITY OF PREMIUM SELECTION
        System.out.println("\nDo you want premium pizza?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        System.out.print("Enter the choice: ");
        choice = Integer.parseInt(System.console().readLine());
        boolean isPremium = false;
        if (choice == 1) {
            isPremium = true;
        }

        // CREATE OBJECT RECEIPT
        Receipt receipt = new Receipt(isVeg, isPremium, pizzaName, pizzaSize, quantity);
        double cost = receipt.getCost();
        receipt.costBeforeDiscount = cost;  // STORE THE COST BEFORE ANY DISCOUNT

        // FUNCTIONALITY FOR SELECTING EXTRA TOPPING
        System.out.println("\nDo you want to add extra toppings?");
        System.out.println("1. Cheese");
        System.out.println("2. Chicken");
        System.out.println("3. Onion");
        System.out.println("4. No toppings");
        System.out.print("Enter the choice: ");
        choice = Integer.parseInt(System.console().readLine());
        if (choice != 4) {
            String topping = "";
            if (choice == 1) {
                topping = "cheese";
            } else if (choice == 2) {
                topping = "chicken";
            } else if (choice == 3) {
                topping = "onion";
            }
            cost = receipt.addToppings(cost, topping);
        }

        // FUNCTIONALITY FOR SELECTING DISCOUNT COUPON
        System.out.println("\nDo you have a discount coupon?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter the choice: ");
        choice = Integer.parseInt(System.console().readLine());

        if (choice == 1) {

            // HASHMAP FOR STORING COUPON CODES AND DISCOUNT 
            Map<String, Double> couponCodes = new HashMap<>();
            couponCodes.put("DISCOUNT10", 0.10);
            couponCodes.put("DISCOUNT20", 0.20);
            couponCodes.put("DISCOUNT30", 0.30);

            System.out.print("Enter the discount coupon code: ");
            String couponCode = System.console().readLine().trim().toUpperCase();

            // CHECKING DISCOUNT COUPON CODE IS AVAILABLE AND APPLY 
            if (couponCodes.containsKey(couponCode)) {
                double discount = couponCodes.get(couponCode);
                cost = receipt.addDiscount(cost, discount);
                receipt.couponCode = couponCode;  
                System.out.println("Congratulations! Coupon applied! You got a " + (discount * 100) + "% discount.");
            } else {
                System.out.println("Invalid coupon code! No discount applied.");
            }
        }

        cost = receipt.addTax(cost); //ADDING TAX IN TOTAL COST
        receipt.printReceipt(cost);  //PRINT RECEIPT AS TXTFILE
    }
}
