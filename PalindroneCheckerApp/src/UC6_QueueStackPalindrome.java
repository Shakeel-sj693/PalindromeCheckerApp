import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UC6_QueueStackPalindrome {

    public static boolean isPalindromeUsingQueueAndStack(String input) {
        if (input == null) return false;

        String cleaned = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        Queue<Character> queue = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cleaned.length(); i++) {
            char c = cleaned.charAt(i);
            queue.add(c);
            stack.push(c);
        }

        while (!queue.isEmpty()) {
            char fromQueue = queue.remove();
            char fromStack = stack.pop();
            if (fromQueue != fromStack) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        boolean result = isPalindromeUsingQueueAndStack(s);

        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }

        sc.close();
    }
}