import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LcaTest {

    lca l = new lca(30, 8, 52, 3, 20, 10, 29);

    @Test
    public void firstCase() {
        assertEquals(30, l.findLowestCommonAncestor(8, 52));
    }

    @Test
    public void secondCase() {
        assertEquals(8, l.findLowestCommonAncestor(3, 29));
    }
}
