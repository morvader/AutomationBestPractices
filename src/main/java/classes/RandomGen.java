package classes;

import java.util.Random;

public class RandomGen {
    public boolean getRandomBool(){
        Random randomGenerator = new Random();
        return randomGenerator.nextBoolean();
    }
}
