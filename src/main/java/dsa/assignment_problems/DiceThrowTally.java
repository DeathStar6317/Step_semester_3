import java.util.Arrays;

public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int roll : rolls) {
            if (roll < 1 || roll > 6) {
                throw new IllegalArgumentException(
                    "Each dice roll must be between 1 and 6."
                );
            }

            count[roll]++;
        }

        System.out.print("Counts: ");
        for (int value = 1; value <= 6; value++) {
            System.out.print(value + ":" + count[value]);

            if (value < 6) {
                System.out.print(" ");
            }
        }
        System.out.println();

        int[] sorted = new int[rolls.length];
        int index = 0;

        for (int value = 1; value <= 6; value++) {
            for (int j = 0; j < count[value]; j++) {
                sorted[index] = value;
                index++;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};

        int[] sorted = diceSort(rolls);
        System.out.println("Sorted: " + Arrays.toString(sorted));

        System.out.println();

        int[] ownRolls = {6, 3, 3, 1, 5, 2};
        int[] ownSorted = diceSort(ownRolls);
        System.out.println("Sorted: " + Arrays.toString(ownSorted));
    }
}
