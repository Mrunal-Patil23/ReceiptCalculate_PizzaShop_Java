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