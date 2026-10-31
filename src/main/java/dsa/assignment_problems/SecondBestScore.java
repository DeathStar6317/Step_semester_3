public class SecondBestScore {
    public static int secondHighest(int[] scores) {
        int highest = -1, second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest(new int[]{45, 78, 92, 78, 60}));
        System.out.println(secondHighest(new int[]{50, 50, 50}));
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
Sorting alternative: O(n log n) time.
*/
