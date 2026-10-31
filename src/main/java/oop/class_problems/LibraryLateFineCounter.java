
import java.util.Scanner;

abstract class LibraryItemFine {
    protected String title;
    protected int daysLate;

    LibraryItemFine(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class BookFine extends LibraryItemFine {
    BookFine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVDFine extends LibraryItemFine {
    DVDFine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MagazineFine extends LibraryItemFine {
    MagazineFine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        LibraryItemFine[] items = new LibraryItemFine[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            switch (type) {
                case "BOOK":
                    items[i] = new BookFine(title, daysLate);
                    break;
                case "DVD":
                    items[i] = new DVDFine(title, daysLate);
                    break;
                case "MAGAZINE":
                    items[i] = new MagazineFine(title, daysLate);
                    break;
            }
        }

        double total = 0;

        for (LibraryItemFine item : items) {
            double fine = item.calculateFine();
            System.out.printf("%s: %.2f%n", item.title, fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
