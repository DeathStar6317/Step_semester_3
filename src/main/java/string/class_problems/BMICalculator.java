package string.class_problems;

import java.util.Scanner;

public class BMICalculator {

    static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println("\nWellness Report");
        System.out.println("------------------------------------------------");
        System.out.printf("%-10s %-12s %-12s %-15s%n",
                "Person", "Height(m)", "Weight(kg)", "BMI / Status");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);

            String status = getBmiStatus(bmi);

            System.out.printf("%-10d %-12.2f %-12.2f %.2f / %s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    status);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int people = 10;

        double[] heights = new double[people];
        double[] weights = new double[people];

        for (int i = 0; i < people; i++) {

            System.out.println("Person " + (i + 1));

            System.out.print("Enter height in meters: ");
            heights[i] = sc.nextDouble();

            System.out.print("Enter weight in kg: ");
            weights[i] = sc.nextDouble();
        }

        printWellnessReport(heights, weights);

        sc.close();
    }
}