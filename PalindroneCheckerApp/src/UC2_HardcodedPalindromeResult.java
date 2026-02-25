public class UC2_HardcodedPalindromeResult {

    public static void main(String[] args) {
        String input = "madam";

        boolean isPalindrome = isPalindrome(input);

        System.out.println("Input: " + input);
        System.out.println(isPalindrome ? "Palindrome" : "Not a palindrome");
    }

    private static boolean isPalindrome(String s) {
        if (s == null) return false;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}