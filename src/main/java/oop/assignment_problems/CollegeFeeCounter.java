
import java.util.Scanner;

interface CollegeBusUser {
}

abstract class CollegeStudent {
    protected String name;
    private static final double TRANSPORT_FEE = 12000.0;

    CollegeStudent(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    double calculateTotalFee() {
        double fee = calculateTuition();

        if (this instanceof CollegeBusUser) {
            fee += TRANSPORT_FEE;
        }

        return fee;
    }
}

class DayScholarStudent extends CollegeStudent
        implements CollegeBusUser {
    DayScholarStudent(String name) {
        super(name);
    }

    @Override
    double calculateTuition() {
        return 40000.0;
    }
}

class HostellerStudent extends CollegeStudent {
    HostellerStudent(String name) {
        super(name);
    }

    @Override
    double calculateTuition() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends CollegeStudent
        implements CollegeBusUser {
    ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    double calculateTuition() {
        return 20000.0;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        CollegeStudent[] students = new CollegeStudent[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students[i] = new DayScholarStudent(name);
                    break;
                case "HOSTELLER":
                    students[i] = new HostellerStudent(name);
                    break;
                case "SCHOLAR":
                    students[i] = new ScholarshipStudent(name);
                    break;
            }
        }

        double total = 0;

        for (CollegeStudent student : students) {
            double fee = student.calculateTotalFee();
            System.out.printf("%s: %.2f%n", student.name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
