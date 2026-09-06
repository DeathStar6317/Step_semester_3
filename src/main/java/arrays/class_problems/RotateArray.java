package arrays.class_problems;

import java.util.Scanner;

public class RotateArray {
    static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter rotation count: ");
        int k = sc.nextInt();

        int[] result = rotateArray(nums, k);

        System.out.print("Rotated Array: ");
        for (int value : result) {
            System.out.print(value + " ");
        }

        sc.close();
    }
}