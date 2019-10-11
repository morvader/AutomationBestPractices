package unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import unit.classes.AcessService;
import unit.classes.Person;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnitBasicTest {

    @Test
    void minors_should_have_freeAccess() throws Exception {
        //ARRANGE
        Person minor = new Person("John", 10, null);
        boolean expectedFreeAccess = true;

        //ACT
        final boolean actualFreeAccess = AcessService.haveFreeAccess(minor);

        //ASSERT
        assertThat("Minors should have free access",
                actualFreeAccess,
                is(expectedFreeAccess));
    }

    @Test
    void ageUnder0_should_ThrowException() {
        //ARRANGE
        Person minor = new Person("John", -5, null);

        //ACT - ASSERT
        assertThrows(Exception.class, () -> {
            AcessService.haveFreeAccess(minor);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 0, 15, 17})
    void minors_should_have_freeAccess_Parametrized(int age) throws Exception {
        //ARRANGE
        Person minor = new Person("John", age, null);
        boolean expectedFreeAccess = true;

        //ACT
        final boolean actualFreeAccess = AcessService.haveFreeAccess(minor);

        //ASSERT
        assertThat("Minors should have free access",
                actualFreeAccess,
                is(expectedFreeAccess));
    }
}
