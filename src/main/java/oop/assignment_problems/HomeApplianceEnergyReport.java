
import java.util.Scanner;

interface SaverMode {
    double getEnergyMultiplier();
}

abstract class HomeAppliance {
    protected double hours;
    private static final double COST_PER_UNIT = 8.0;

    HomeAppliance(double hours) {
        this.hours = hours;
    }

    abstract double getPowerRating();
    abstract String getApplianceType();

    double calculateUnits(boolean saverRequested) {
        double units = getPowerRating() * hours / 1000.0;

        if (saverRequested && this instanceof SaverMode) {
            units *= ((SaverMode) this).getEnergyMultiplier();
        }

        return units;
    }

    double calculateCost(double units) {
        return units * COST_PER_UNIT;
    }
}

class FridgeAppliance extends HomeAppliance {
    FridgeAppliance(double hours) {
        super(hours);
    }

    @Override
    double getPowerRating() {
        return 150.0;
    }

    @Override
    String getApplianceType() {
        return "FRIDGE";
    }
}

class ACAppliance extends HomeAppliance implements SaverMode {
    ACAppliance(double hours) {
        super(hours);
    }

    @Override
    double getPowerRating() {
        return 1500.0;
    }

    @Override
    public double getEnergyMultiplier() {
        return 0.75;
    }

    @Override
    String getApplianceType() {
        return "AC";
    }
}

class TVAppliance extends HomeAppliance {
    TVAppliance(double hours) {
        super(hours);
    }

    @Override
    double getPowerRating() {
        return 100.0;
    }

    @Override
    String getApplianceType() {
        return "TV";
    }
}

class WasherAppliance extends HomeAppliance implements SaverMode {
    WasherAppliance(double hours) {
        super(hours);
    }

    @Override
    double getPowerRating() {
        return 500.0;
    }

    @Override
    public double getEnergyMultiplier() {
        return 0.75;
    }

    @Override
    String getApplianceType() {
        return "WASHER";
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HomeAppliance[] appliances = new HomeAppliance[n];
        boolean[] saverRequested = new boolean[n];
        boolean[] rejected = new boolean[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            String option = "";
            if (sc.hasNextLine()) {
                String remaining = sc.nextLine().trim();
                if (!remaining.isEmpty()) {
                    option = remaining;
                }
            }

            saverRequested[i] = option.equals("SAVER");

            switch (type) {
                case "FRIDGE":
                    appliances[i] = new FridgeAppliance(hours);
                    break;
                case "AC":
                    appliances[i] = new ACAppliance(hours);
                    break;
                case "TV":
                    appliances[i] = new TVAppliance(hours);
                    break;
                case "WASHER":
                    appliances[i] = new WasherAppliance(hours);
                    break;
            }

            rejected[i] = saverRequested[i]
                    && !(appliances[i] instanceof SaverMode);
        }

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            HomeAppliance appliance = appliances[i];

            if (rejected[i]) {
                System.out.println(appliance.getApplianceType()
                        + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(saverRequested[i]);
            double cost = appliance.calculateCost(units);

            System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                    appliance.getApplianceType(), units, cost);

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
