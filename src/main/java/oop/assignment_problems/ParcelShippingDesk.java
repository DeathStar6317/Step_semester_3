
import java.util.Scanner;

interface InsurableParcel {
    double calculateInsurance();
}

abstract class ShippingParcel {
    protected double weight;
    protected double declaredValue;

    ShippingParcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();
    abstract String getType();

    double calculateTotal() {
        double insurance = 0;

        if (this instanceof InsurableParcel) {
            insurance = ((InsurableParcel) this).calculateInsurance();
        }

        return calculateCharge() + insurance;
    }

    double getInsurance() {
        if (this instanceof InsurableParcel) {
            return ((InsurableParcel) this).calculateInsurance();
        }
        return 0;
    }
}

class StandardParcel extends ShippingParcel {
    StandardParcel(double weight, double value) {
        super(weight, value);
    }

    @Override
    double calculateCharge() {
        return 40 + 10 * weight;
    }

    @Override
    String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends ShippingParcel
        implements InsurableParcel {
    ExpressParcel(double weight, double value) {
        super(weight, value);
    }

    @Override
    double calculateCharge() {
        return 80 + 15 * weight;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    @Override
    String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends ShippingParcel
        implements InsurableParcel {
    FragileParcel(double weight, double value) {
        super(weight, value);
    }

    @Override
    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }

    @Override
    String getType() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ShippingParcel[] parcels = new ShippingParcel[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            switch (type) {
                case "STANDARD":
                    parcels[i] = new StandardParcel(weight, value);
                    break;
                case "EXPRESS":
                    parcels[i] = new ExpressParcel(weight, value);
                    break;
                case "FRAGILE":
                    parcels[i] = new FragileParcel(weight, value);
                    break;
            }
        }

        double grandTotal = 0;

        for (ShippingParcel parcel : parcels) {
            double charge = parcel.calculateCharge();
            double insurance = parcel.getInsurance();
            double total = parcel.calculateTotal();

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getType(), charge, insurance, total);

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
