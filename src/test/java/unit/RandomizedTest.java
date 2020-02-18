package unit;

import com.github.javafaker.Faker;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import unit.classes.AcessService;
import unit.classes.Person;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.jeasy.random.FieldPredicates.named;

public class RandomizedTest {

    @Test
    @RepeatedTest(10)
    void fakeValuesTest() throws Exception {
        final Faker faker = Faker.instance();
        Person person = new Person(faker.name().fullName(),
                faker.number().numberBetween(0, 17), null);

        boolean expectedFreeAccess = true;

        //ACT
        final boolean actualFreeAccess = AcessService.haveFreeAccess(person);

        //ASSERT
        assertThat("Minors should have free access",
                actualFreeAccess,
                is(expectedFreeAccess));
    }

    @Test
    @RepeatedTest(10)
    void randomizedTest() throws Exception {
        EasyRandomParameters params = new EasyRandomParameters();
        params.randomize(named("age"), () -> Faker.instance().number().numberBetween(0, 17));

        EasyRandom easyRandom = new EasyRandom(params);

        Person person = easyRandom.nextObject(Person.class);
        boolean expectedFreeAccess = true;

        //ACT
        final boolean actualFreeAccess = AcessService.haveFreeAccess(person);

        //ASSERT
        assertThat("Minors should have free access",
                actualFreeAccess,
                is(expectedFreeAccess));
    }
}
