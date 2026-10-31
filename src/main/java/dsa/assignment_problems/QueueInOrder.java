public class QueueInOrder {

    public static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        int[] tokens2 = {1, 2, 2, 7};
        int[] tokens3 = {};
        int[] tokens4 = {5};

        System.out.println(firstBreak(tokens1));
        System.out.println(firstBreak(tokens2));
        System.out.println(firstBreak(tokens3));
        System.out.println(firstBreak(tokens4));
    }
}
