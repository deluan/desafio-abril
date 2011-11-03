import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PrimeTest {

    prime_less pl = new prime_less();

    private int number;
    private boolean isPrime;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {0, false}, {1, false},
                {2, true}, {3, true},
                {4, false}, {5, true},
                {6, false}, {7, true},
                {8, false}, {9, false},
                {10, false}, {11, true},
        });
    }

    public PrimeTest(int number, boolean isPrime) {
        this.number = number;
        this.isPrime = isPrime;
    }


    @Test
    public void checkForPrime() {
        assertEquals(isPrime, pl.isPrime(number));
    }

}
