
import java.util.Scanner;

abstract class CinemaTicket {
    protected int count;
    private static final double CONVENIENCE_FEE = 20.0;

    CinemaTicket(int count) {
        this.count = count;
    }

    abstract double getPrice();
    abstract String getSeatType();

    double calculateAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends CinemaTicket {
    RegularTicket(int count) {
        super(count);
    }

    @Override
    double getPrice() {
        return 150.0;
    }

    @Override
    String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends CinemaTicket {
    PremiumTicket(int count) {
        super(count);
    }

    @Override
    double getPrice() {
        return 250.0;
    }

    @Override
    String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends CinemaTicket {
    ReclinerTicket(int count) {
        super(count);
    }

    @Override
    double getPrice() {
        return 400.0;
    }

    @Override
    String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        CinemaTicket[] tickets = new CinemaTicket[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();

            switch (type) {
                case "REGULAR":
                    tickets[i] = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    tickets[i] = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    tickets[i] = new ReclinerTicket(count);
                    break;
            }
        }

        double total = 0;

        for (CinemaTicket ticket : tickets) {
            double amount = ticket.calculateAmount();
            System.out.printf("%s: %.2f%n",
                    ticket.getSeatType(), amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
