/**
 * =========================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * =========================================================
 *
 * Use Case 12 : Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This application dynamically selects a palindrome
 * checking algorithm at runtime using the Strategy Pattern.
 *
 * Concepts Used:
 * - Interface
 * - Polymorphism
 * - Strategy Pattern
 * - Stack & Deque Data Structures
 *
 * @author Developer
 * @version 1.0
 */

import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * Strategy Interface
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * Stack-based Strategy Implementation
 */
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        if (input == null) return false;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/**
 * Deque-based Strategy Implementation
 */
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        if (input == null) return false;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

/**
 * Context Class
 */
class PalindromeService {

    private PalindromeStrategy strategy;

    // Constructor Injection
    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    // Setter Injection (optional dynamic change)
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.check(input);
    }
}

/**
 * Application Entry Point
 */
public class PalindromeCheckerApp1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter input string: ");
        String input = scanner.nextLine();

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");

        int choice = scanner.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        // Inject strategy at runtime
        PalindromeService service = new PalindromeService(strategy);

        boolean result = service.checkPalindrome(input);

        System.out.println("Is Palindrome? : " + result);

        scanner.close();
    }
}