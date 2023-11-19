import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BlackBoxTest {
    public static void main(String[] args) {    
    }
    public static int sin(int x, boolean square, boolean increment, boolean negate) {
        if (square) x *= x;
        if (increment) x++;
        if (negate) x *= -1;
        return x;
    }
    @Test
    public void testAllFalse() {
        assertEquals(4, sin(4, false, false, false));
    }
    @Test
    public void testSquare() {
        assertEquals(16, sin(4, true, false, false));
    }
    @Test
    public void testIncrement() {
        assertEquals(5, sin(4, false, true, false));
    }
    @Test
    public void testNegate() {
        assertEquals(-4, sin(4, false, false, true));
    }
    @Test
    public void testSquareIncrement() {
        assertEquals(17, sin(4, true, true, false));
    }
    @Test
    public void testSquareNegate() {
        assertEquals(-16, sin(4, true, false, true));
    }
    @Test
    public void testIncrementNegate() {
        assertEquals(-5, sin(4, false, true, true));
    }
    @Test
    public void testAlltrue() {
        assertEquals(-17, sin(4, true, true, true));
    }

}