
import java.util.Scanner;

abstract class Plot {
    protected String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    abstract String getShape();
}

class CirclePlot extends Plot {
    private double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    String getShape() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    String getShape() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            switch (shape) {
                case "CIRCLE":
                    plots[i] = new CirclePlot(owner, sc.nextDouble());
                    break;
                case "RECTANGLE":
                    plots[i] = new RectanglePlot(
                            owner, sc.nextDouble(), sc.nextDouble());
                    break;
                case "TRIANGLE":
                    plots[i] = new TrianglePlot(
                            owner, sc.nextDouble(), sc.nextDouble());
                    break;
            }
        }

        double total = 0;

        for (Plot plot : plots) {
            double area = plot.calculateArea();
            System.out.printf("%s (%s): %.2f%n",
                    plot.owner, plot.getShape(), area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
