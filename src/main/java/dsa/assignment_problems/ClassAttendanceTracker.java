public class ClassAttendanceTracker {
    public static int[] attendanceSummary(int[] days) {
        int present = 0, currentStreak = 0, longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }
        return new int[]{present, longestStreak};
    }

    public static void main(String[] args) {
        int[] result = attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1});
        System.out.println("Present: " + result[0]
                + ", Longest streak: " + result[1]);

        result = attendanceSummary(new int[]{0, 0, 0});
        System.out.println("Present: " + result[0]
                + ", Longest streak: " + result[1]);
    }
}

/*
Time Complexity: O(n)
Additional Space Complexity: O(1)
Both results are calculated in a single pass.
*/
