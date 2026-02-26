import java.util.Scanner;
import java.util.Stack;

/**
 * UC11: Object-Oriented Palindrome Service
 * This class encapsulates the logic for palindrome validation.
 */
class PalindromeChecker {

    /**
     * Checks if a string is a palindrome using a Stack.
     * @param input The string to validate
     * @return boolean true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {
        // Handle null or empty cases
        if (input == null || input.isEmpty()) {
            return false;
        }

        // Clean the string: remove non-alphanumeric and convert to lowercase
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters of the cleaned string onto the stack
        for (char c : cleanInput.toCharArray()) {
            stack.push(c);
        }

        // Pop from stack to build the reversed string
        StringBuilder reversedInput = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedInput.append(stack.pop());
        }

        // Compare original cleaned string with reversed version
        return cleanInput.equals(reversedInput.toString());
    }
}

public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("--- Palindrome Checker (OOPS Edition) ---");
        System.out.print("Enter a string to check: ");
        String userInput = scanner.nextLine();

        if (checker.checkPalindrome(userInput)) {
            System.out.println("Result: '" + userInput + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + userInput + "' is NOT a palindrome.");
        }

        scanner.close();
    }
}