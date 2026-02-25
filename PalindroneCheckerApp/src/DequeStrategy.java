import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;

        String cleaned = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < cleaned.length(); i++) {
            deque.addLast(cleaned.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }

        return true;
    }
}