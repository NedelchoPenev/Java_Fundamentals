import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_Iterator_Test.ListIterator;

import javax.naming.OperationNotSupportedException;

public class p03_Iterator_Tests {

    private ListIterator listIterator;

    @Before
    public void initialize() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("Hi!", "My", "Name", "Is", "...");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorWithNullShouldThrowException() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(null);
    }

    @Test
    public void constructorWithNoParametersShouldNotHaveNext() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();

        Assert.assertFalse(this.listIterator.hasNext());
    }

    @Test
    public void moveMethodShouldReturnTrueIfThereIsNextElement() throws OperationNotSupportedException {
        boolean expectedValue = true;

        Assert.assertTrue(this.listIterator.move() == expectedValue);
    }

    @Test
    public void moveMethodShouldReturnFalseIfThereIsNoNextElement() throws OperationNotSupportedException {
        boolean expectedValue = false;

        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();

        Assert.assertTrue(this.listIterator.move() == expectedValue);
    }

    @Test
    public void hasNextShouldReturnTrueIfThereIsNextElement(){
        boolean expectedValue = true;

        Assert.assertEquals(this.listIterator.hasNext(), expectedValue);
    }

    @Test
    public void hasNextShouldReturnFalseIfThereIsNoNextElement() throws OperationNotSupportedException {
        boolean expectedValue = false;

        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();

        Assert.assertTrue(this.listIterator.hasNext() == expectedValue);
    }

    @Test
    public void printCurrentIndexShouldBeCorrect(){
        String expectedValue = "Hi!";

        Assert.assertEquals(this.listIterator.print(), expectedValue);
    }

    @Test
    public void printNextIndexShouldBeCorrect(){
        String expectedValue = "My";

        this.listIterator.move();

        Assert.assertEquals(this.listIterator.print(), expectedValue);
    }

    @Test(expected = IllegalStateException.class)
    public void printIfNoElementsAreStoredShouldThrowException() throws Exception {
        this.listIterator = new ListIterator();

        this.listIterator.print();
    }
}
