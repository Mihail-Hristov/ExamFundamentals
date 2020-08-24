import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double totalPrice = 0.0;
        double tax = 0;
        double totalPriceWithTax = 0;
        boolean special = false;
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("special") || input.equals("regular")) {
                if (input.equals("special")) {
                    special = true;
                }
                break;
            }

            double currentPrice = Double.parseDouble(input);
            if (currentPrice <= 0) {
                System.out.println("Invalid price!");
            } else {
                totalPrice += currentPrice;
            }
        }

        tax = totalPrice * 0.2;
        totalPriceWithTax = totalPrice + tax;
        if (special) {
            totalPriceWithTax = totalPriceWithTax * 0.9;
        }

        if (totalPriceWithTax == 0) {
            System.out.println("Invalid order!");
        }else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.println(String.format("Price without taxes: %.2f$", totalPrice));
            System.out.println(String.format("Taxes: %.2f$", tax));
            System.out.println("-----------");
            System.out.println(String.format("Total price: %.2f$", totalPriceWithTax));
        }
    }
}
