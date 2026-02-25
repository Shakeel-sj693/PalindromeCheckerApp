public class PalindromeService {

    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        if (strategy == null) {
            throw new IllegalStateException("PalindromeStrategy is not set");
        }
        return strategy.isPalindrome(input);
    }
}