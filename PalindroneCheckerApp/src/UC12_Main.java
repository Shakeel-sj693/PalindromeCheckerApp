import java.util.Scanner;

public class UC12_Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        PalindromeService service = new PalindromeService(new DequeStrategy());

        boolean result = service.check(s);

        System.out.println(result ? "Palindrome" : "Not a palindrome");

        service.setStrategy(new StackStrategy());
        boolean result2 = service.check(s);

        System.out.println("Using StackStrategy: " + (result2 ? "Palindrome" : "Not a palindrome"));

        sc.close();
    }
}