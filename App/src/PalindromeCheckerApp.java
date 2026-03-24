/**
 * ============================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 *
 * The application:
 * - Uses a palindrome strategy implementation
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * @author Developer
 * @version 13.0
 */

import java.util.Scanner;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input : ");
        String input = scanner.nextLine();

        // Using Stack Strategy (can compare multiple if needed)
        PalindromeStrategy strategy = new StackStrategy();

        // Start time
        long startTime = System.nanoTime();

        boolean result = strategy.check(input);

        // End time
        long endTime = System.nanoTime();

        // Calculate execution time
        long executionTime = endTime - startTime;

        // Output
        System.out.println("Is Palindrome? : " + result);
        System.out.println("Execution Time : " + executionTime + " ns");

        scanner.close();
    }
}

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

    public boolean check(String input) {

        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push all characters
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare while popping
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}