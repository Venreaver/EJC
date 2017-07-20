package classwork.classwork20072017;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortTest {
    private List<Integer> randomList;
    private List<Integer> sortedList;

    @Before
    public void beforeTest() {
        randomList = new ArrayList<>(10);
        randomList.add(13);
        randomList.add(-15);
        randomList.add(3);
        randomList.add(-111);
        randomList.add(1);
        randomList.add(0);
        randomList.add(2);
        randomList.add(2);
        randomList.add(0);
        randomList.add(119);

        sortedList = new ArrayList<>(10);
        sortedList.add(-111);
        sortedList.add(-15);
        sortedList.add(0);
        sortedList.add(0);
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(2);
        sortedList.add(3);
        sortedList.add(13);
        sortedList.add(119);
    }

    @Test
    public void testInsertionSort() {
        Sorts.insertionSort(randomList);
        Assert.assertEquals("Something going wrong", sortedList, randomList);
    }

    @Test
    public void testQuickSort() {
        Sorts.quickSort(randomList);
        Assert.assertEquals("Something going wrong", sortedList, randomList);
    }
}
