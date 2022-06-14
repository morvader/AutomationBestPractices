package unit;

import classes.AccessService;
import classes.Person;
import classes.RandomGen;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UnitBasicTest {

    @Test
    void minors_should_have_freeAccess() throws Exception {
        //ARRANGE
        Person minor = new Person("John", 10, null);
        boolean expectedFreeAccess = true;

        //ACT
        final boolean actualFreeAccess = AccessService.haveFreeAccess(minor);

        //ASSERT
        assertThat("Minors should have free access",
                actualFreeAccess,
                is(expectedFreeAccess));
    }


    @Test
    void adults_could_have_freeAccess() throws Exception {
        //ARRANGE
        Person adult = new Person("John", 30, null);
        boolean expectedFreeAccess = true;
        RandomGen mockRandomGen = mock(RandomGen.class);

        when(mockRandomGen.getRandomBool()).thenReturn(true);

        AccessService accessService = new AccessService(mockRandomGen);

        //ACT
        final boolean actualFreeAccess = accessService.winFreeAccess(adult);

        //ASSERT
        assertThat("Adults could have free access",
                actualFreeAccess,
                is(expectedFreeAccess));
    }

    @Test
    void ageUnder0_should_ThrowException() {
        //ARRANGE
        Person minor = new Person("John", -5, null);

        //ACT - ASSERT
        assertThrows(Exception.class, () -> {
            AccessService.haveFreeAccess(minor);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 0, 15, 17})
    void minors_should_have_freeAccess_Parametrized(int age) throws Exception {
        //ARRANGE
        Person minor = new Person("John", age, null);
        boolean expectedFreeAccess = true;

        //ACT
        final boolean actualFreeAccess = AccessService.haveFreeAccess(minor);

        //ASSERT
        assertThat("Minors should have free access",
                actualFreeAccess,
                is(expectedFreeAccess));
    }
}
