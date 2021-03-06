import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p08_Custom_Linked_List.CustomLinkedList;

public class p08_Custom_Linked_List_Tests {

    private static final int[] ELEMENTS_TO_BE_ADDED = {1, 3, 134, 21, 313, 2340, 840};
    private static final int ELEMENT_TO_BE_ADDED = 20;
    private static final int NEGATIVE_INDEX = -1;
    private static final int OUT_OF_SIZE_INDEX = 7;

    private CustomLinkedList<Integer> linkedList;

    @Before
    public void initialize(){
        this.linkedList = new CustomLinkedList<>();
        for (int element : ELEMENTS_TO_BE_ADDED) {
            this.linkedList.add(element);
        }
    }

    //get Region
    @Test
    public void getShouldReturnCorrectElement(){
        int currentElement = this.linkedList.get(1);
        int expectedValue = 3;

        Assert.assertEquals(currentElement, expectedValue);
    }

    @Test(expected = Exception.class)
    public void getShouldThrowExceptionWhenIndexIsNegative(){
        int currentElement = this.linkedList.get(NEGATIVE_INDEX);
    }

    @Test(expected = Exception.class)
    public void getShouldThrowExceptionWhenIndexIsMoreThanElementsSize(){
        int currentElement = this.linkedList.get(OUT_OF_SIZE_INDEX);
    }
    //endregion

    //set Region
    @Test
    public void setShouldPutTheElementInCorrectPosition(){
        this.linkedList.set(1, ELEMENT_TO_BE_ADDED);
        int currentElement = this.linkedList.get(1);
        int expectedValue = ELEMENT_TO_BE_ADDED;

        Assert.assertEquals(currentElement, expectedValue);
    }

    @Test(expected = Exception.class)
    public void setShouldThrowExceptionWhenIndexIsNegative(){
        this.linkedList.set(NEGATIVE_INDEX, ELEMENT_TO_BE_ADDED);
    }

    @Test(expected = Exception.class)
    public void setShouldThrowExceptionWhenIndexIsMoreThanElementsSize(){
        this.linkedList.set(OUT_OF_SIZE_INDEX, ELEMENT_TO_BE_ADDED);
    }

    //endregion

//  add region
    @Test
    public void addMethodShouldAddElementAtTheEndOfTheList(){
        this.linkedList.add(ELEMENT_TO_BE_ADDED);
        int currentValue = this.linkedList.get(OUT_OF_SIZE_INDEX);
        int expectedValue = ELEMENT_TO_BE_ADDED;

        Assert.assertEquals(currentValue, expectedValue);
    }
//    endregion

//    remove region

//    The same for the other.
//    Finish if there is enough time.
}
