package unit.classes;

public class AcessService {

    public static boolean haveFreeAccess(Person person) throws Exception {
        if (person.getAge() < 0) throw new Exception("Age should be greater than 0");

        return person.getAge() < 18;

    }
}
