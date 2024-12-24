package process;

import dictionary.Dictionary;
import dictionary.UserDictionary;

import java.util.Scanner;

public class ConsoleHangMan {

    private final Scanner scanner = new Scanner(System.in);
    private final Dictionary dictionary = new UserDictionary();
    private static final int maxAttempt = 5;

    public void run() {
        Session session = new Session(dictionary, maxAttempt);
        while (true) {
            GuessResult result = tryGuess(session);
            printState(result);
            if (result instanceof GuessResult.Win || result instanceof GuessResult.Defeat) {
                break;
            }
        }
    }

    private GuessResult tryGuess(Session session){
        System.out.print("Guess a letter or give up:\n");
        String input = scanner.nextLine().trim().toLowerCase();
        if (input.equals("give up")) {
            return session.giveUp();
        } else if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
            return session.guess(input.charAt(0));
        } else {
            return null;
        }
    }

    private void printState(GuessResult guess){
        System.out.println(guess.message());
        System.out.println("The word: " + new String(guess.state()));
    }
}


