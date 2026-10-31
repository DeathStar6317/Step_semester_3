public class ExamScoreBandCounter {
    public static int countInBand(int[] scores, int low, int high) {
        return upperBound(scores, high) - lowerBound(scores, low);
    }

    private static int lowerBound(int[] scores, int target) {
        int left = 0, right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int upperBound(int[] scores, int target) {
        int left = 0, right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}

/*
Binary search: O(log n) time, O(1) extra space.
Linear scan: O(n) time, O(1) extra space.
lowerBound finds the first score >= low.
upperBound finds the first score > high.
This correctly includes duplicates at both boundaries.
*/
