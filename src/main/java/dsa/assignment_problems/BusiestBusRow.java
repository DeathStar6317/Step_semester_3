public class BusiestBusRow {
    public static int[] busiestRow(int[][] grid) {
        int bestRow = 0, highestTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int total = 0;

            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }

            if (total > highestTotal) {
                highestTotal = total;
                bestRow = i;
            }
        }
        return new int[]{bestRow, highestTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}

/*
Time Complexity: O(r * c)
Additional Space Complexity: O(1)
Strictly greater comparison preserves the smaller row index on ties.
*/
