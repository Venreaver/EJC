package classwork.classwork24072017;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortsAndSearchTest {
    private int[] arrayWithSearchElement;
    private int[] sortedArrayWithSearchElement;
    private int[] arrayWithoutSearchElement;
    private int[] sortedArrayWithoutSearchElement;
    private int searchElement;
    private int searchElementIndex;
    private int noElementInArrayIndex;

    @Before
    public void beforeTest() {
        searchElementIndex = 5;
        noElementInArrayIndex = -1;
        arrayWithSearchElement =
                new int[]{464, 641, -122, -429, 372, -680, 82, 0, -928, 394, 541, -30, 705, 150, 565};
        sortedArrayWithSearchElement =
                new int[]{-928, -680, -429, -122, -30, 0, 82, 150, 372, 394, 464, 541, 565, 641, 705};
        arrayWithoutSearchElement =
                new int[]{-929, 886, -580, 588, 150, 143, -266, 918, -556, -245, 588, 804, -956, 882, -566};
        sortedArrayWithoutSearchElement =
                new int[]{-956, -929, -580, -566, -556, -266, -245, 143, 150, 588, 588, 804, 882, 886, 918};
    }

    @Test
    public void testBubbleSort() {
        SortsAndSearch.bubbleSort(arrayWithoutSearchElement);
        Assert.assertArrayEquals("Something going wrong",
                arrayWithoutSearchElement, sortedArrayWithoutSearchElement);
    }

    @Test
    public void testMergeSort() {
        SortsAndSearch.mergeSort(arrayWithSearchElement);
        Assert.assertArrayEquals("Something going wrong",
                arrayWithSearchElement, sortedArrayWithSearchElement);
    }

    @Test
    public void testBinarySearchIndexFound() {
        Assert.assertEquals("Something going wrong", searchElementIndex,
                SortsAndSearch.binarySearch(sortedArrayWithSearchElement, searchElement));
    }

    @Test
    public void testBinarySearchIndexNotFound() {
        Assert.assertEquals("Something going wrong", noElementInArrayIndex,
                SortsAndSearch.binarySearch(sortedArrayWithoutSearchElement, searchElement));
    }
}
