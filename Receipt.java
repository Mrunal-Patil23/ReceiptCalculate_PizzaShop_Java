<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;

public class Receipt {

    //CREATE VARIABLE 
    private boolean isVeg;
    private boolean isPremium;
    private String topping = "No toppings";
    private double discountApplied = 0.0;
    private String couponCode = "None";
    private double costBeforeDiscount;

    // CONSTRUCTOR FOR ACCESSING PRIVATE VARIABLES
    public Receipt(boolean isVeg, boolean isPremium) {
        this.isVeg = isVeg; //DIFF. WITH PRIVATE VARIABLES AND PUBLIC BCOZ USE OF SAME VARIABLE
        this.isPremium = isPremium;
    }

    // METHOD TO ADD BASE COST
    public double getCost() {
        double cost = 0;
        if (isVeg) {
            cost += 250;
        } else {
            cost += 300;
        }
        if (isPremium) {
            cost += 100;
        }
        return cost;
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
        return cost + cost * 0.05;
    }

    // METHOD TO ADD DISCOUNT
    public double addDiscount(double cost, double discount) {
        discountApplied = discount;
        return cost - (cost * discount);
    }

    // FUNCTION TO PRINT THE RECEIPT WITH DETAILS
    public void printReceipt(double finalCost) {
        System.out.println("\n****** Receipt ******");
        System.out.println("\nPizza Type: " + (isVeg ? "Veg" : "Non-Veg"));
        System.out.println("Premium: " + (isPremium ? "Yes" : "No"));
        System.out.println("Toppings: " + topping);
        System.out.println("Discount Coupon: " + couponCode);
        System.out.println("Discount Applied: " + (discountApplied * 100) + "%");
        System.out.println("Cost before discount: " + costBeforeDiscount);
        System.out.println("Total cost including tax: " + finalCost);
        System.out.println("\n****** Thank You! Visit Again ******");
    }

    // Main method
    public static void main(String[] args) {

        //FUNCTIONALITY FOR VEG OR NOVEG SELECTION
        System.out.println("\n****** Welcome to PIZZA shop! ******");
        System.out.println("\nSelect the pizza type: ");
        System.out.println("1. Veg");
        System.out.println("2. Non-Veg");

        System.out.print("Enter the choice: ");
        int choice = Integer.parseInt(System.console().readLine());
        boolean isVeg = false;
        if (choice == 1) {
            isVeg = true;
        }

        //FUNCTIONALITY OF PREMIUM SELECTION
        System.out.println("\nDo you want premium pizza?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        System.out.print("Enter the choice: ");
        choice = Integer.parseInt(System.console().readLine());
        boolean isPremium = false;
        if (choice == 1) {
            isPremium = true;
        }

        //CREATE OBJECT RECEIPT
        Receipt receipt = new Receipt(isVeg, isPremium);
        double cost = receipt.getCost();
        receipt.costBeforeDiscount = cost;  // STORE THE COST BEFORE ANY DISCOUNT

        //FUNCTIONALITY FOR SELECTING EXTRA TOPPING
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

        //FUNCTIONALITY FOR SELECTING DISCOUNT COUPON
        System.out.println("\nDo you have a discount coupon?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter the choice: ");
        choice = Integer.parseInt(System.console().readLine());

        if (choice == 1) {

            //HASMAP FOR STORING COUPON CODES AND DISCOUNT 
            Map<String, Double> couponCodes = new HashMap<>();
            couponCodes.put("DISCOUNT10", 0.10);
            couponCodes.put("DISCOUNT20", 0.20);
            couponCodes.put("DISCOUNT30", 0.30);

            System.out.print("Enter the discount coupon code: ");
            String couponCode = System.console().readLine().trim().toUpperCase();

            //CHECKING DISCOUNT COUPON CODE IS AVAIABLE AND APPLY 
            if (couponCodes.containsKey(couponCode)) {
                double discount = couponCodes.get(couponCode);
                cost = receipt.addDiscount(cost, discount);
                receipt.couponCode = couponCode;  
                System.out.println("Coupon applied! You got a " + (discount * 100) + "% discount.");
            } else {
                System.out.println("Invalid coupon code! No discount applied.");
            }
        }

        cost = receipt.addTax(cost);
        receipt.printReceipt(cost);  
    }
}
=======
import java.util.HashMap;
import java.util.Map;

public class Receipt {

    //CREATE VARIABLE FOR VEG OR PREMIUM
    private boolean isVeg;
    private boolean isPremium;

    //CONSTRUCTOR 
    public Receipt(boolean isVeg, boolean isPremium){
        this.isVeg = isVeg; //DIFF. WITH PRIVATE VARIABLES AND PUBLIC BCOZ USE OF SAME VARIABLE
        this.isPremium = isPremium;
    }

    //CREATE FUNCTION FOR COST
    public double getCost(){
        double cost = 0;

        if (isVeg) {
            cost += 250;
        }
        else {
            cost += 300;
        }
        if (isPremium) {
            cost += 100;
        }
        return cost;
    }

    //FUNCTION FOR ADD TOPING
    public double addToppings(double cost, String toping){
        if (toping.equals("cheese")) {
            cost += 20;
        }
        else if (toping.equals("chicken")) {
            cost += 50;
        }
        else if (toping.equals("onion")) {
            cost += 15;
        }
        return cost;
    }

    //FUNCTION FOR ADD TAX
    public double addTax(double cost){
        return cost + cost * 0.05;
    }

    //FUNCTION FOR ADD DISCOUNTS
    public double addDiscount(double cost, double discount){
        return cost - cost * discount;
    }

    public static void main(String[] args) {

        System.out.println("\n****** Welcome to PIZZA shop! ******");
        System.out.println("\nSelect the pizza type: ");
        System.out.println("1. Veg");
        System.out.println("2. Non-Veg");

        System.out.print("Enter the choice: ");
        int choice = Integer.parseInt(System.console().readLine());
        boolean isVeg = false;
        if (choice == 1) {
            isVeg = true;
        }

        //OPTIONS AND FUNCTIONALITY FOR PREMIUM OR NOT
        System.out.println("\nDo you want premium pizza?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter the choice: ");
        choice = Integer.parseInt(System.console().readLine());
        boolean isPremium = false;
        if (choice == 1) {
            isPremium = true;
        }
        Receipt receipt = new Receipt(isVeg, isPremium);
        double cost = receipt.getCost();

        //OPTIONS AND FUNCTIONALITY FOR EXTRA TOPPINGS
        System.out.println("\nDo you want to add extra toppings?");
        System.out.println("1. Cheese");
        System.out.println("2. Chicken");
        System.out.println("3. Onion");
        System.out.println("4. No toppings");
        System.out.print("Enter the choice: ");
        choice = Integer.parseInt(System.console().readLine());
        if (choice!=4) {
            String topping = "";
            if (choice==1) {
                topping = "Cheese";
            }
            else if (choice == 2) {
                topping = "Chicken";
            }
            else if (choice == 3) {
                topping = "Onion";
            }
            cost = receipt.addToppings(cost, topping);
        }

        //OPTIONS AND FUNCTIONALITY FOR DISCOUNT
        System.out.println("\nDo you have any discount coupon?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter the choice: ");
        choice = Integer.parseInt(System.console().readLine());
            if (choice == 1) {
                Map<String, Double> couponCodes = new HashMap<>();
                couponCodes.put("DISCOUNT10", 0.10);
                couponCodes.put("DISCOUNT20", 0.20);
                couponCodes.put("DISCOUNT30", 0.30);

                System.out.print("Enter the discount coupon code: ");
                String couponCode = System.console().readLine().trim().toUpperCase();

            if (couponCodes.containsKey(couponCode)) {
                    double discount = couponCodes.get(couponCode);
                    cost = receipt.addDiscount(cost, discount);
                    System.out.println("\nCongratulations! Your Coupon applied! You got a " + (discount * 100) + "% discount.");
            }
            else {
                System.out.println("Invalid coupon code! No discount applied.");
            }
        }

        cost = receipt.addTax(cost);
        System.out.println("\n****** Receipt ******");
        System.out.println("\nTotal cost including tax is: "+cost);
        System.out.println("\n****** Thank You! Visit Again ******\n");

    }
}
>>>>>>> 46e33feb7fdab0b7b1b99a75b134b4630d58ba87
