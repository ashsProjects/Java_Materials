import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WhiteBoxTest {
    
    public static void main(String[] args) {
        
    }

    public static int sin(int x, boolean square, boolean increment, boolean negate) {
        if (square || increment || negate) {
            x *= x;
            if (increment || negate) {
                x++;
                if (negate) {
                    x = -x;
                }
            }
        }
        return x;
    }

    @Test
    public void statementCoverage() {
        assertEquals(-17, sin(4, true, true, true));
    }

    @Test
    public void branchCoverage() {
        assertEquals(4, sin(4, false, false, false));
        assertEquals(-17, sin(4, true, true, true));
    }

    @Test
    public void pathCoverage() {
        assertEquals(4, sin(4, false, false, false));
        assertEquals(16, sin(4, true, false, false));
        assertEquals(17, sin(4, false, true, false));
        assertEquals(-17, sin(4, false, false, true));
        assertEquals(17, sin(4, true, true, false));
        assertEquals(-17, sin(4, true, false, true));
        assertEquals(-17, sin(4, false, true, true));
        assertEquals(-17, sin(4, true, true, true));
    }

}
