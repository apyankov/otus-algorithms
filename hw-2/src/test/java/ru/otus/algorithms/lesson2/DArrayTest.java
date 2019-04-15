package ru.otus.algorithms.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DArrayTest extends _ArrayBaseTest {

    private static final String SAMPLE_STRING = "hello";


    DArrayTest() { // подключаем базовые тесты для _Array
        super(DArray::new);
    }


    @Test
    @DisplayName("для block-capacity >0 capacity тоже работает")
    void capacityForBlockTest() {
        DArray<String> arr = new DArray<String>(2, 5);
        int index = 6;
        arr.add(index, SAMPLE_STRING);

        Assertions.assertTrue(arr.capacity() >= index + 1); // т.к. индекс отсчитывается от 0, то capacity = +1, и, увеличена с учетом размера блока
    }
}
