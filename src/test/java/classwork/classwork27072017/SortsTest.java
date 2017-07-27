package classwork.classwork27072017;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortsTest {
    private int[] array;
    private int[] sortedArray;

    @Before
    public void beforeTest() {
        array = new int[]{886, 83, 0, 96, 1, 870, 23, 995, 990, 295, 440, 138, 1, 670, 4};
        sortedArray = new int[]{0, 1, 1, 4, 23, 83, 96, 138, 295, 440, 670, 870, 886, 990, 995};
    }

    @Test
    public void testSelectionSort() {
        Sorts.selectionSort(array);
        Assert.assertArrayEquals("Something going wrong", array, sortedArray);
    }

    @Test
    public void testRadixSortLSD() {
        Sorts.radixSortLSD(array);
        Assert.assertArrayEquals("Something going wrong", array, sortedArray);
    }
}
