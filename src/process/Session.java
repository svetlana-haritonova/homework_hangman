package process;

import dictionary.Dictionary;

public class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(Dictionary dictionary, int maxAttempts) {
        this.answer = dictionary.randomWord();
        this.userAnswer = new char[answer.length()];
        this.attempts = 0;
        this.maxAttempts = 5;
        for (int i = 0; i < userAnswer.length; ++i) {
            userAnswer[i] = '*';
        }
    }

    public GuessResult guess(char guess) {
        boolean Guess = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = guess;
                Guess = true;
            }
        }
        ++attempts;
        if (new String(userAnswer).equals(answer)) {
            return new GuessResult.Win(userAnswer, attempts, maxAttempts, "You won!");
        } else if (Guess) {
            --attempts;
            return new GuessResult.SuccessfulGuess(userAnswer, attempts, maxAttempts, "Hit!");
        } else {
            if (attempts == maxAttempts) {
                return new GuessResult.Defeat(userAnswer, attempts, maxAttempts, "Missed, mistake " + attempts + " out of " + maxAttempts + ".\nYou lost!");
            }
            return new GuessResult.FailedGuess(userAnswer, attempts, maxAttempts, "Missed, mistake " + attempts + " out of " + maxAttempts + ".");
        }
    }

    public GuessResult giveUp() {
        return new GuessResult.Defeat(userAnswer, attempts, maxAttempts, "The end.");
    }
}
