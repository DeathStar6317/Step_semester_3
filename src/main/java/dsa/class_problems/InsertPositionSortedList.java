public class InsertPositionSortedList {
    public static int searchInsertPosition(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 2));
    }
}

/*
Time: O(log n)
Auxiliary space: O(1)
Binary search finds either the target or its insertion position.
*/
