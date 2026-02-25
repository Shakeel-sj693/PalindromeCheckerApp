import java.util.Scanner;

public class UC8_LinkedListPalindrome {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    public static boolean isPalindromeUsingLinkedList(String input) {
        if (input == null) return false;

        String cleaned = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        if (cleaned.length() <= 1) return true;

        Node head = buildList(cleaned);

        Node slow = head;
        Node fast = head;
        Node prevSlow = null;

        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalfStart = (fast != null) ? slow.next : slow;

        Node reversedSecondHalf = reverse(secondHalfStart);

        boolean palindrome = true;
        Node p1 = head;
        Node p2 = reversedSecondHalf;

        while (p2 != null) {
            if (p1.data != p2.data) {
                palindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        Node restoredSecondHalf = reverse(reversedSecondHalf);

        if (fast != null) {
            slow.next = restoredSecondHalf;
        } else if (prevSlow != null) {
            prevSlow.next = restoredSecondHalf;
        }

        return palindrome;
    }

    private static Node buildList(String s) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < s.length(); i++) {
            Node node = new Node(s.charAt(i));
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        return head;
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        boolean result = isPalindromeUsingLinkedList(s);

        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }

        sc.close();
    }
}