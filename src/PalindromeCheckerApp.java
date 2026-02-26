/**
 * =========================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * =========================================================
 *
 * Use Case 13 : Performance Comparison
 *
 * Description:
 * This application compares execution time of multiple
 * palindrome algorithms using System.nanoTime().
 *
 * Algorithms Compared:
 * 1. Two Pointer Approach
 * 2. Stack-Based Approach
 * 3. StringBuilder Reverse Approach
 *
 * Concepts Used:
 * - System.nanoTime()
 * - Algorithm Benchmarking
 * - Clean Method Separation
 *
 * @author Developer
 * @version 1.0
 */

import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter input string: ");
        String input = scanner.nextLine();

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Run Two Pointer
        long start1 = System.nanoTime();
        boolean result1 = twoPointerCheck(normalized);
        long end1 = System.nanoTime();

        // Run Stack
        long start2 = System.nanoTime();
        boolean result2 = stackCheck(normalized);
        long end2 = System.nanoTime();

        // Run StringBuilder Reverse
        long start3 = System.nanoTime();
        boolean result3 = stringBuilderCheck(normalized);
        long end3 = System.nanoTime();

        System.out.println("\n===== Results =====");
        System.out.println("Two Pointer Result      : " + result1);
        System.out.println("Execution Time (ns)     : " + (end1 - start1));

        System.out.println("\nStack Strategy Result   : " + result2);
        System.out.println("Execution Time (ns)     : " + (end2 - start2));

        System.out.println("\nStringBuilder Result    : " + result3);
        System.out.println("Execution Time (ns)     : " + (end3 - start3));

        scanner.close();
    }

    /**
     * Algorithm 1: Two Pointer Approach
     */
    private static boolean twoPointerCheck(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * Algorithm 2: Stack-Based Approach
     */
    private static boolean stackCheck(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        for (char c : s.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Algorithm 3: StringBuilder Reverse Approach
     */
    private static boolean stringBuilderCheck(String s) {

        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}