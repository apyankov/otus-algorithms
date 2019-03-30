package ru.otus.algorithms.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class _ArrayTest {

    private static final String SAMPLE_STRING = "hello";

    private Supplier<_Array<String>> arraySupplier;


    _ArrayTest(Supplier<_Array<String>> arraySupplier) {
        this.arraySupplier = arraySupplier;
    }


    @Test
    @DisplayName("get возвращает то, что было add")
    void insertDataTest(){
        _Array<String> arr = arraySupplier.get();
        arr.add(0, SAMPLE_STRING);
        String restored = arr.get(0);

        Assertions.assertEquals(SAMPLE_STRING, restored);
    }

    @Test
    @DisplayName("size возвращает корректное значение")
    void sizeTest(){
        _Array<String> arr = arraySupplier.get();
        int index = 5;
        arr.add(index, SAMPLE_STRING);

        Assertions.assertEquals(index + 1, arr.size()); // т.к. индекс отсчитывается от 0, то size = +1
    }
}
