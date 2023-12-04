package app;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    static double purchaseValue;
    static double discount;
    static double discountValue;
    static double pureValue;
    static String purchaseValueRounded;
    static String discountValueRounded;
    static String forPaymentRounded;
    private static final String CURRENCY = "USD";

    public static void main(String[] args) {

        handleData();
        getOutput();

    }

    private static void getOutput() {
        System.out.println("\nSum of your purchase is " + purchaseValueRounded + " "
                + CURRENCY + "\nYour discount is " + discountValueRounded + " "
                + CURRENCY + "\nSum for payment is " + forPaymentRounded +
                " " + CURRENCY);
    }

    private static void handleData() {

        purchaseValue = getData();
        discount = calcDiscount(purchaseValue);
        discountValue = calcDiscountValue(discount, purchaseValue);
        pureValue = calcForPayment(purchaseValue, discountValue);
        purchaseValueRounded = roundData(purchaseValue);
        discountValueRounded = roundData(discountValue);
        forPaymentRounded = roundData(pureValue);
    }

    private static double getData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter the sum of the purchase: ");
        return sc.nextDouble();
    }


    private static double calcDiscount(double purchase) {

        if (purchase > 10000) {
            return 0.15;
        } else if (purchase > 5000) {
            return 0.10;
        } else {
            return 0.05;
        }
    }

    private static double calcDiscountValue(double discount, double purchase) {

        return discount * purchase;
    }

    private static double calcForPayment(double purchase, double discountValue) {
        return purchase - discountValue;
    }

    public static String roundData(double data) {
        return new DecimalFormat("#.00").format(data);
    }

}


