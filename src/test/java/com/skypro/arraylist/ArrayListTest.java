package com.skypro.arraylist;

import com.skypro.arraylist.service.ArrayListService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    private ArrayListService arrayListService;
    private final static String TEST = "Test";
    private final static String TEST_2 = "Test2";
    private final static int INDEX = 1;
    private final static String TEST_3 = "Test3";
    private final static String TEST_4 = "Test4";
    private final static String EMPTY_STRING = " ";
    private final static String NOT_STRING = "";

    @BeforeEach
    public void setUp() {
        arrayListService = new ArrayListService(4);
        arrayListService.add(TEST);
        arrayListService.add(TEST_2);

    }

    @Test
    public void add(){
        assertSame(arrayListService.add(TEST), TEST);
    }

    @Test
    public void addWithIndex() {
        assertEquals(arrayListService.add(INDEX, TEST_2), TEST_2);
    }

    @Test
    public void setItem() {
        assertEquals(arrayListService.set(INDEX, TEST_3),TEST_3);
    }

    @Test
    public void remove() {
        assertEquals(arrayListService.remove(TEST), TEST);
    }

    @Test
    public void removeWithIndex() {
        arrayListService.remove(INDEX);
    }

    @Test
    public void containsTrue() {
        assertTrue(arrayListService.contains(TEST_2));
    }

    @Test
    public void containsFalse() {
        assertFalse(arrayListService.contains(TEST_3));
    }

    @Test
    public void indexOf() {
        assertEquals(1, arrayListService.indexOf(TEST_2));
    }

    @Test
    public void lastIndexOf() {
        assertEquals(1, arrayListService.lastIndexOf(TEST_2));
    }

    @Test
    public void get() {
        assertEquals(TEST_2, arrayListService.get(INDEX));
    }

    @Test
    public void equals() {
        ArrayListService test = new ArrayListService(2);
        test.add(TEST_4);
        test.add(TEST_3);
        assertFalse(arrayListService.equals(test));
    }

    @Test
    public void size() {
        assertEquals(2, arrayListService.size());
    }

    @Test
    public void isEmpty() {
        assertFalse( arrayListService.isEmpty());
    }

    @Test
    public void clear() {
        arrayListService.clear();
        assertEquals(0, arrayListService.size());
    }

    @Test
    public void toArray() {
        String[] test = new String[] {TEST, TEST_2};
        assertArrayEquals(test, arrayListService.toArray());
    }


}
