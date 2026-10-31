import java.util.Scanner;

abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();

    String getType() {
        return "";
    }
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount * 1.02;
    }

    String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount * 1.01;
    }

    String getType() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) {
        super(amount);
    }

    double calculateFinalAmount() {
        return amount;
    }

    String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Payment[] payments = new Payment[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            switch (type) {
                case "CARD":
                    payments[i] = new CardPayment(amount);
                    break;
                case "WALLET":
                    payments[i] = new WalletPayment(amount);
                    break;
                case "BANKTRANSFER":
                    payments[i] = new BankTransferPayment(amount);
                    break;
                default:
                    System.out.println("Invalid payment type");
                    return;
            }
        }

        for (Payment payment : payments) {
            double adjusted = payment.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", payment.getType(), adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}