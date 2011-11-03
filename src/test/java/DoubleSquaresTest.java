import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DoubleSquaresTest {

    double_squares ds = new double_squares();

    @Test
    public void intIsInt() {
        assertTrue(ds.isInt(10.0));
    }


    @Test
    public void floatIsNotInt() {
        assertFalse(ds.isInt(0.1));
    }


    @Test
    public void zeroIsInt() {
        assertTrue(ds.isInt(0.0));
    }


    @Test
    public void firstCase() {
        assertEquals(1, ds.dp(10));
    }

    @Test
    public void secondCase() {
        assertEquals(2, ds.dp(25));
    }

    @Test
    public void thirdCase() {
        assertEquals(0, ds.dp(3));
    }

    @Test
    public void forthCase() {
        assertEquals(1, ds.dp(0));
    }


}
