package classes;

public class AccessService {

    private static RandomGen rand;

    public AccessService(RandomGen rnd) {
        this.rand = rnd;
    }

    public static boolean haveFreeAccess(Person person) throws Exception {
        if (person.getAge() < 0) throw new Exception("Age should be greater than 0");

        return person.getAge() < 18;

    }

    public boolean winFreeAccess(Person person) throws Exception {
        if (person.getAge() > 18)
            return rand.getRandomBool();
        return true;

    }
}
