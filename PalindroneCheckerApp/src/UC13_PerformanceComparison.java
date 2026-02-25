import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class UC13_PerformanceComparison {

    private static String normalize(String input) {
        if (input == null) return null;
        return input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    }

    public static boolean twoPointer(String input) {
        if (input == null) return false;
        String s = normalize(input);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean stackBased(String input) {
        if (input == null) return false;
        String s = normalize(input);
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) stack.push(s.charAt(i));
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != stack.pop()) return false;
        }
        return true;
    }

    public static boolean dequeBased(String input) {
        if (input == null) return false;
        String s = normalize(input);
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) deque.addLast(s.charAt(i));
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    public static boolean recursionBased(String input) {
        if (input == null) return false;
        String s = normalize(input);
        return rec(s, 0, s.length() - 1);
    }

    private static boolean rec(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return rec(s, left + 1, right - 1);
    }

    private static long timeNanos(Runnable r, int iterations) {
        int warmup = Math.min(10_000, iterations / 10 + 1);
        for (int i = 0; i < warmup; i++) r.run();
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) r.run();
        return System.nanoTime() - start;
    }

    private static void print(String name, long totalNanos, int iterations, boolean lastResult) {
        double avgMicros = (double) totalNanos / iterations / 1_000.0;
        System.out.printf("%-12s | total: %12d ns | avg: %10.2f µs | last=%s%n", 
                name, totalNanos, avgMicros, lastResult);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to benchmark: ");
        String input = sc.nextLine();

        System.out.print("Iterations (e.g., 100000): ");
        int iterations = Integer.parseInt(sc.nextLine().trim());

        final boolean[] last = new boolean[1];

        long t1 = timeNanos(() -> last[0] = twoPointer(input), iterations);
        boolean r1 = last[0];

        long t2 = timeNanos(() -> last[0] = stackBased(input), iterations);
        boolean r2 = last[0];

        long t3 = timeNanos(() -> last[0] = dequeBased(input), iterations);
        boolean r3 = last[0];

        long t4 = timeNanos(() -> last[0] = recursionBased(input), iterations);
        boolean r4 = last[0];

        System.out.println();
        System.out.println("UC13 Performance Comparison (System.nanoTime)");
        print("TwoPointer", t1, iterations, r1);
        print("StackBased", t2, iterations, r2);
        print("DequeBased", t3, iterations, r3);
        print("Recursion", t4, iterations, r4);

        if (!(r1 == r2 && r2 == r3 && r3 == r4)) {
            System.out.println();
            System.out.println("Warning: Algorithms returned different results.");
        }

        sc.close();
    }
}