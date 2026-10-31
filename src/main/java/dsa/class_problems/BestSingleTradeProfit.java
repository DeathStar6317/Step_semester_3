public class BestSingleTradeProfit {
    public static int maxProfit(int[] prices) {
        int minimum = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minimum) {
                minimum = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minimum);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}

/*
Single pass: O(n) time, O(1) space.
Checking every pair: O(n^2) time, O(1) space.
The single-pass approach scales better.
*/
