
import java.util.Scanner;

interface NightService {
    double applyNightSurcharge(double fare);
}

abstract class CityCab {
    protected double distance;
    private static final double MINIMUM_FARE = 100.0;

    CityCab(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();
    abstract String getCabType();

    double calculateFare(boolean isNight) {
        double fare = Math.max(calculateBaseFare(), MINIMUM_FARE);

        if (isNight && this instanceof NightService) {
            fare = ((NightService) this).applyNightSurcharge(fare);
        }

        return fare;
    }
}

class MiniCab extends CityCab {
    MiniCab(double distance) {
        super(distance);
    }

    @Override
    double calculateBaseFare() {
        return distance * 10.0;
    }

    @Override
    String getCabType() {
        return "MINI";
    }
}

class SedanCab extends CityCab implements NightService {
    SedanCab(double distance) {
        super(distance);
    }

    @Override
    double calculateBaseFare() {
        return distance * 14.0;
    }

    @Override
    public double applyNightSurcharge(double fare) {
        return fare * 1.20;
    }

    @Override
    String getCabType() {
        return "SEDAN";
    }
}

class SUVCab extends CityCab implements NightService {
    SUVCab(double distance) {
        super(distance);
    }

    @Override
    double calculateBaseFare() {
        return distance * 18.0;
    }

    @Override
    public double applyNightSurcharge(double fare) {
        return fare * 1.20;
    }

    @Override
    String getCabType() {
        return "SUV";
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        CityCab[] cabs = new CityCab[n];
        boolean[] nightTrips = new boolean[n];
        boolean[] rejected = new boolean[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            String time = sc.next();

            nightTrips[i] = time.equals("NIGHT");

            switch (type) {
                case "MINI":
                    cabs[i] = new MiniCab(distance);
                    break;
                case "SEDAN":
                    cabs[i] = new SedanCab(distance);
                    break;
                case "SUV":
                    cabs[i] = new SUVCab(distance);
                    break;
            }

            rejected[i] = nightTrips[i]
                    && !(cabs[i] instanceof NightService);
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            CityCab cab = cabs[i];

            if (rejected[i]) {
                System.out.println(
                        cab.getCabType() + ": night service not available");
            } else {
                double fare = cab.calculateFare(nightTrips[i]);
                System.out.printf("%s: %.2f%n",
                        cab.getCabType(), fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
