public class UC3_StringReversePalindrome {

    public static void main(String[] args) {
        String input = "level";

        String reversed = reverseUsingLoop(input);

        boolean isPalindrome = input.equals(reversed);

        System.out.println("Input: " + input);
        System.out.println("Reversed: " + reversed);
        System.out.println(isPalindrome ? "Palindrome" : "Not a palindrome");
    }

    private static String reverseUsingLoop(String s) {
        if (s == null) return "";
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed = reversed + s.charAt(i);
        }
        return reversed;
    }
}