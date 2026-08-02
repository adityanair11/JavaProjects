class Calculator {
    static int count = 0;

    static int add(int a, int b) {
        count++;
        return a+b;
    }

    static double add(double a, double b) {
        count++;
        return a+b;
    }

    static int add(int a, int b, int c) {
        count++;
        return a+b+c;
    }
}

class Restaurant {
    static int totalOrders = 0;

    static double calculateBill(double itemCost) {
        //dinein: 10% service charge
        totalOrders++;
        return itemCost + (itemCost * 0.10);
    }

    static double calculateBill(double itemCost, boolean takeaway) {
        //takeaway: 5% packaging charge
        totalOrders++;
        return itemCost + (itemCost * 0.05);
    }

    static double calculateBill(double itemCost, double deliveryCharge) {
        //delivery: item+delivery charge
        totalOrders++;
        return itemCost + deliveryCharge;
    }
}

public class Assignment3 {
    public static void main(String[] args) {
        //calculator
        System.out.println("\nCalculator:");
        System.out.println("Add ints: " + Calculator.add(5, 3));
        System.out.println("Add doubles: " + Calculator.add(4.5, 2.3));
        System.out.println("Add three ints: " + Calculator.add(1, 2, 3));
        System.out.println("Total calculations: " + Calculator.count);

        //restuarant billing
        System.out.println("\nRestaurant Billing");
        System.out.println("Dine-in bill: ₹" + Restaurant.calculateBill(500));
        System.out.println("Takeaway bill: ₹" + Restaurant.calculateBill(300, true));
        System.out.println("Delivery bill: ₹" + Restaurant.calculateBill(400, 50.0));
        System.out.println("Total orders: " + Restaurant.totalOrders + "\n");
    }
}