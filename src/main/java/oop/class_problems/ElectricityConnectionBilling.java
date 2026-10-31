
import java.util.Scanner;

abstract class ElectricityConnection {
    protected int units;

    ElectricityConnection(int units) {
        this.units = units;
    }

    abstract double calculateBill();

    abstract String getType();
}

class HomeConnection extends ElectricityConnection {
    HomeConnection(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        }

        return 100 * 5.0 + (units - 100) * 7.0;
    }

    @Override
    String getType() {
        return "HOME";
    }
}

class ShopConnection extends ElectricityConnection {
    ShopConnection(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 8.0 + 100;
    }

    @Override
    String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends ElectricityConnection {
    FactoryConnection(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }

    @Override
    String getType() {
        return "FACTORY";
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ElectricityConnection[] connections =
                new ElectricityConnection[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            switch (type) {
                case "HOME":
                    connections[i] = new HomeConnection(units);
                    break;
                case "SHOP":
                    connections[i] = new ShopConnection(units);
                    break;
                case "FACTORY":
                    connections[i] = new FactoryConnection(units);
                    break;
            }
        }

        double total = 0;

        for (ElectricityConnection connection : connections) {
            double bill = connection.calculateBill();
            System.out.printf("%s: %.2f%n",
                    connection.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
