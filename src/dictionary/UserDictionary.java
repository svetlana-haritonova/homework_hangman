package dictionary;

import java.util.Random;

public class UserDictionary implements Dictionary {
    private final String[] dictionary = {"biology", "chemistry", "history", "literature", "geography", "maths", "english", "art", "science", "music", "russian", "informatics", "algebra", "geometry"};
    private final Random random = new Random();

    @Override
    public String randomWord() {
        return dictionary[random.nextInt(dictionary.length)];
    }
}
