import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int borrowingDays();

    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(borrowingDays());
    }
}

class BookItem extends LibraryItem {
    BookItem(String title) {
        super(title);
    }

    int borrowingDays() {
        return 14;
    }
}

class DVDItem extends LibraryItem {
    DVDItem(String title) {
        super(title);
    }

    int borrowingDays() {
        return 7;
    }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title) {
        super(title);
    }

    int borrowingDays() {
        return 3;
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');

            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            switch (type.toUpperCase()) {
                case "BOOK":
                    items[i] = new BookItem(title);
                    break;
                case "DVD":
                    items[i] = new DVDItem(title);
                    break;
                case "MAGAZINE":
                    items[i] = new MagazineItem(title);
                    break;
                default:
                    System.out.println("Invalid item type");
                    return;
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.getDueDate());
        }

        sc.close();
    }
}