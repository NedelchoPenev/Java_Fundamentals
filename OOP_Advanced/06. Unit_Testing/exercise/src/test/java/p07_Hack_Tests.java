import org.junit.Assert;
import org.junit.Test;

public class p07_Hack_Tests {

    @Test
    public void testMathAbsWithInt(){
        int a = 5;
        int b = -10;

        int expectedValue = 15;
        int currentValue = Math.abs(b - a);

        Assert.assertEquals(expectedValue, currentValue);
    }

    @Test
    public void testMathAbsWithDouble(){
        double a = 5.12;
        double b = -10.123256;

        double value = a - b;
        double expectedValue = (value <= 0.0D) ? 0.0D - value : value;
        double currentValue = Math.abs(a - b);

        Assert.assertTrue(expectedValue == currentValue);
    }

    @Test
    public void testMathFloor(){
        double value = 10.123256;

        int expectedValue = 10;
        int currentValue = (int) Math.floor(value);

        Assert.assertEquals(expectedValue, currentValue);
    }

    @Test
    public void testSystemLineSeparator() {
        String lineSeparator = System.lineSeparator();
        String expectedValue = String.format("%n");

        Assert.assertEquals(expectedValue, lineSeparator);
    }
}
