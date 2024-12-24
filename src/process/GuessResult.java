package process;

public interface GuessResult {
    char[] state();
    String message();

    record Defeat(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {

    }

    record Win(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {

    }

    record SuccessfulGuess(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {

    }

    record FailedGuess(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {

    }
}
