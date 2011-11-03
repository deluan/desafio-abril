import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PrimeLessTest {

    prime_less pl = new prime_less();


    private Set<Integer> parseSet(String set) {
        String[] nums = set.split(",");

        Set<Integer> result = new HashSet<Integer>();

        for (String n: nums) {
            result.add(Integer.parseInt(n));
        }

        return result;
    }


    @Test
    public void firstCase() {
        assertEquals(parseSet("2,3,5,7"), pl.findAllPrimesUntil(10));
    }

    @Test
    public void secondCase() {
        assertEquals(parseSet("2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97"),
                pl.findAllPrimesUntil(100));
    }

    @Test
    public void thirdCase() {
        assertEquals(parseSet("2,3,5,7,11,13,17,19"), pl.findAllPrimesUntil(20));
    }

    @Test
    public void fourthCase() {
        assertEquals(parseSet("2,3,5"), pl.findAllPrimesUntil(7));
    }

}
