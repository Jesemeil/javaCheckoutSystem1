import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Product {
    private final String name;
    private final double price;
    private final int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    public double getTotalPrice() {
        return price * quantity;
    }
}


public class CheckoutSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayList<Product> products = new ArrayList<>();
        String customerName;
        String cashierName;
        double discountPercentage;


        System.out.println("What is the customer's name?");
        customerName = scanner.nextLine();


        while (true) {
            System.out.println("What did the user buy?");
            String productName = scanner.nextLine();

            System.out.println("How many pieces?");
            int quantity = Integer.parseInt(scanner.nextLine());

            System.out.println("How much per unit?");
            double price = Double.parseDouble(scanner.nextLine());

            products.add(new Product(productName, price, quantity));

            System.out.println("Add more items? (Yes/No)");
            String moreItems = scanner.nextLine().trim().toLowerCase();
            if (moreItems.equals("no")) {
                break;
            }
        }


        System.out.println("What is your name? (Cashier's name)");
        cashierName = scanner.nextLine();

        System.out.println("How much discount will the customer get? (Enter a percentage)");
        discountPercentage = Double.parseDouble(scanner.nextLine());


        double total = 0;
        for (Product product : products) {
            total += product.getTotalPrice();
        }
        double discountAmount = total * (discountPercentage / 100);
        double vat = total * 0.175;
        double billTotal = total - discountAmount + vat;

        System.out.println("\nSEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
        System.out.println("TEL: 83293828343");
        System.out.println("Date: " + new SimpleDateFormat("dd-MMM-yy h:mm:ssa").format(new Date()));
        System.out.println("Cashier: " + cashierName);
        System.out.println("Customer Name: " + customerName);
        System.out.println("=================================================================================================================");
        System.out.println("          ITEM                  QTY              PRICE         TOTAL(NGN)");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (Product product : products) {
            System.out.printf("%15s%20d%20.2f%20.2f%n", product.getName(), product.getQuantity(), product.getPrice(), product.getTotalPrice());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%55s%.2f%n", "Sub Total:", total);
        System.out.printf("%55s%.2f%n", "Discount:", discountAmount);
        System.out.printf("%55s%.2f%n", "VAT@ 17.5%:", vat);
        System.out.println("==================================================================================================================");
        System.out.printf("%55s%.2f%n", "BILL TOTAL:", billTotal);
        System.out.println("==================================================================================================================");
        System.out.println("==================================================================================================================");
        System.out.printf("%55s%.2f%n", "THIS IS NOT A RECEIPT KINDLY PAY ", billTotal);
        System.out.println("==================================================================================================================");
        System.out.println("How much did the customer give to you?");
        double amountPaid = Double.parseDouble(scanner.nextLine());


        double balance = amountPaid - billTotal;
        System.out.println("\nSEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
        System.out.println("TEL: 83293828343");
        System.out.println("Date: " + new SimpleDateFormat("dd-MMM-yy h:mm:ssa").format(new Date()));
        System.out.println("Cashier: " + cashierName);
        System.out.println("Customer Name: " + customerName);
        System.out.println("==================================================================================================================");
        System.out.println("          ITEM                  QTY              PRICE         TOTAL(NGN)");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (Product product : products) {
            System.out.printf("%15s%20d%20.2f%20.2f%n", product.getName(), product.getQuantity(), product.getPrice(), product.getTotalPrice());
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%55s%.2f%n", "Sub Total:", total);
        System.out.printf("%55s%.2f%n", "Discount:", discountAmount);
        System.out.printf("%55s%.2f%n", "VAT@ 17.5%:", vat);
        System.out.println("==================================================================================================================");
        System.out.printf("%55s%.2f%n", "BILL TOTAL:", billTotal);
        System.out.printf("%55s%.2f%n", "AMOUNT PAID:", amountPaid);
        System.out.printf("%55s%.2f%n", "BALANCE:", balance);
        System.out.println("==================================================================================================================");
        System.out.println("\n\nTHANK YOU FOR YOUR PATRONAGE");
        System.out.println("==================================================================================================================");
    }
}
