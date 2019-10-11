package unit.classes;

public class Person {

    private final String name;
    private final int age;
    final String email = "";

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;

    }

    public int getAge() {
        return this.age;
    }
}
