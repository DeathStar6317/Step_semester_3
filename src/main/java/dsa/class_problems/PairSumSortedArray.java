import java.util.Arrays;

public class PairSumSortedArray {
    public static int[] pairSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] result = pairSumSorted(new int[]{-4, -1, 0, 3, 5, 9}, 4);
        System.out.println(result == null ? "Not Found" : Arrays.toString(result));

        result = pairSumSorted(new int[]{1, 2, 3}, 100);
        System.out.println(result == null ? "Not Found" : Arrays.toString(result));
    }
}

/*
Sorted two-pointer approach: O(n) time, O(1) auxiliary space.
Checking all pairs without using sorted order: O(n^2) time.
*/
