import java.util.HashSet;
import java.util.Set;

public class TransactionDuplicateCheck {
    public static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();

        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate(
                new String[]{"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"}));
        System.out.println(hasDuplicate(
                new String[]{"TXN2001", "TXN2002", "TXN2003"}));
    }
}

/*
Average time: O(n)
Space: O(n)
Alternative: nested loops use O(1) extra space but O(n^2) time.
Sorting can take O(n log n) time, depending on the sorting algorithm.
*/
