public class UC4_CharArrayTwoPointerPalindrome {

    public static void main(String[] args) {
        String input = "madam";

        boolean isPalindrome = isPalindromeCharArray(input);

        System.out.println("Input: " + input);
        System.out.println(isPalindrome ? "Palindrome" : "Not a palindrome");
    }

    // UC4: convert to char[] and use two pointers
    private static boolean isPalindromeCharArray(String s) {
        if (s == null) return false;

        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }
}