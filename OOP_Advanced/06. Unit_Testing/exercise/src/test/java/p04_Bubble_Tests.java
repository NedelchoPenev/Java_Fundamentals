import org.junit.Assert;
import org.junit.Test;
import p04_Bubble_Sort_Test.Bubble;

import java.util.Arrays;

public class p04_Bubble_Tests {

    @Test
    public void mixedElements(){
        int[] mixed = {3, 7, 1, 15, 17, 10, 2};
        String expectedValue = "[1, 2, 3, 7, 10, 15, 17]";

        Bubble.sort(mixed);

        Assert.assertEquals(expectedValue, Arrays.toString(mixed));
    }

    @Test
    public void alreadySortedElements(){
        int[] elements = {1, 2, 3, 7, 10, 15, 17};
        String expectedValue = "[1, 2, 3, 7, 10, 15, 17]";

        Bubble.sort(elements);

        Assert.assertEquals(expectedValue, Arrays.toString(elements));
    }

    @Test
    public void decreasingElements(){
        int[] elements = {17, 15, 10, 7, 3, 2, 1};
        String expectedValue = "[1, 2, 3, 7, 10, 15, 17]";

        Bubble.sort(elements);

        Assert.assertEquals(expectedValue, Arrays.toString(elements));
    }

    @Test
    public void decreasingWithDuplicates() {
        int[] inputArray = {4, 3, 2, 1, 2, 3, 2};
        String expected = "[1, 2, 2, 2, 3, 3, 4]";

        Bubble.sort(inputArray);

        Assert.assertEquals(expected, Arrays.toString(inputArray));
    }

    @Test
    public void zeroValues() {
        int[] inputArray = {0,0};
        String expected = "[0, 0]";

        Bubble.sort(inputArray);

        Assert.assertEquals(expected, Arrays.toString(inputArray));
    }

    @Test
    public void intMaxValue() {
        int[] inputArray = {Integer.MAX_VALUE, 0};
        String expected = String.format("[0, %d]", Integer.MAX_VALUE);

        Bubble.sort(inputArray);

        Assert.assertEquals(expected, Arrays.toString(inputArray));
    }

    @Test
    public void intMinValue() {
        int[] inputArray = {Integer.MIN_VALUE, 0};
        String expected = String.format("[%d, 0]", Integer.MIN_VALUE);

        Bubble.sort(inputArray);

        Assert.assertEquals(expected, Arrays.toString(inputArray));
    }

    @Test
    public void sortOneElementShouldExists() {
        int[] inputArray = {0};
        String expected = "[0]";

        Bubble.sort(inputArray);

        Assert.assertEquals(expected, Arrays.toString(inputArray));
    }
}
