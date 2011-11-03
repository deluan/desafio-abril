import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HappyNumbersTest {

    happy_numbers hn = new happy_numbers();

    @Test
    public void nextNumberForOneDigit() {
        assertEquals(81, hn.nextNumber(9));
    }

    @Test
    public void nextNumberForTwoDigits() {
        assertEquals(82, hn.nextNumber(19));
    }

    @Test
    public void nextNumberForThreeDigits() {
        assertEquals(10, hn.nextNumber(310));
    }

    @Test
    public void firstCase() {
        assertEquals(true, hn.isHappyNumber(1));
    }

    @Test
    public void secondCase() {
        assertEquals(true, hn.isHappyNumber(7));
    }

    @Test
    public void thirdCase() {
        assertEquals(false, hn.isHappyNumber(22));
    }

}
