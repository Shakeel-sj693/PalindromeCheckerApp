import java.util.ArrayDeque;
import java.util.Deque;

public class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;

        String cleaned = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < cleaned.length(); i++) {
            stack.push(cleaned.charAt(i));
        }

        for (int i = 0; i < cleaned.length(); i++) {
            if (cleaned.charAt(i) != stack.pop()) return false;
        }

        return true;
    }
}