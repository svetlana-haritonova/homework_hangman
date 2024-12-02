package dictionary;

import java.util.Random;

public class UserDictionary implements Dictionary {
    private final String[] dictionary = {"biology", "chemistry", "history", "literature", "geography", "maths", "english", "art", "science", "music", "russian", "informatics", "algebra", "geometry"};

    @Override
    public String randomWord() {
        Random random = new Random();
        return dictionary[random.nextInt(dictionary.length)];
    }
}
