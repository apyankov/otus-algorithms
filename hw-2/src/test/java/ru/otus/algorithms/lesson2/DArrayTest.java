package ru.otus.algorithms.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DArrayTest {

    private static final String SAMPLE_STRING = "hello";

    @Test
    @DisplayName("get возвращает то, что было add")
    void insertDataTest(){
        DArray<String> arr = new DArray<String>();
        arr.add(0, SAMPLE_STRING);
        String restored = arr.get(0);

        Assertions.assertEquals(SAMPLE_STRING, restored);
    }

    @Test
    @DisplayName("size возвращает корректное значение")
    void sizeTest(){
        DArray<String> arr = new DArray<String>();
        int index = 5;
        arr.add(index, SAMPLE_STRING);

        Assertions.assertEquals(index + 1, arr.size()); // т.к. индекс отсчитывается от 0, то size = +1
    }

    @Test
    @DisplayName("для block-size >0 size тоже работает")
    void sizeForBlockTest(){
        DArray<String> arr = new DArray<String>(2, 5);
        int index = 6;
        arr.add(index, SAMPLE_STRING);

        Assertions.assertTrue(arr.size() >= index + 1); // т.к. индекс отсчитывается от 0, то size = +1, и, увеличена с учетом размера блока
    }
}
