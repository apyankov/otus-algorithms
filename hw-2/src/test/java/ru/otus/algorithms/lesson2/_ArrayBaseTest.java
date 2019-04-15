package ru.otus.algorithms.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

class _ArrayBaseTest {

    private static final String SAMPLE_STRING = "hello";

    private Supplier<_Array<String>> arraySupplier;


    _ArrayBaseTest(Supplier<_Array<String>> arraySupplier) {
        this.arraySupplier = arraySupplier;
    }

    @Test
    @DisplayName("get возвращает то, что было add")
    void addDataTest() {
        _Array<String> arr = arraySupplier.get();
        arr.add(0, SAMPLE_STRING);
        String restored = arr.get(0);

        Assertions.assertEquals(SAMPLE_STRING, restored);
    }

    @Test
    @DisplayName("get возвращает то, что было set")
    void setDataTest() {
        _Array<String> arr = arraySupplier.get();
        arr.set(0, SAMPLE_STRING);
        String restored = arr.get(0);

        Assertions.assertEquals(SAMPLE_STRING, restored);
    }

    @Test
    @DisplayName("remove работает корректно для элемента в середине массива")
    void removeMiddleDataTest(){
        _Array<String> arr = arraySupplier.get();
        arr.add(10, SAMPLE_STRING);

        arr.remove(5);

        Assertions.assertEquals(11, arr.size());
    }


    @Test
    @DisplayName("remove работает корректно для последнего элемента")
    void removeLastDataTest(){
        _Array<String> arr = arraySupplier.get();
        arr.add(10, SAMPLE_STRING);

        arr.remove(10 - 1);

        Assertions.assertEquals(9, arr.size());
    }


    @Test
    @DisplayName("capacity возвращает корректное значение")
    void capacityTest() {
        _Array<String> arr = arraySupplier.get();
        int index = 5;
        arr.add(index, SAMPLE_STRING);

        // проверка именно >=, т.к. impl может выделять элементы пачкой
        // т.к. индекс отсчитывается от 0, то capacity это index + 1
        Assertions.assertTrue(arr.capacity() >= index + 1);
    }

    @Test
    @DisplayName("size - при старте равно 0")
    void sizeInitialTest() {
        _Array<String> arr = arraySupplier.get();

        Assertions.assertEquals(0, arr.size());
    }

    @Test
    @DisplayName("size возвращает корректное значение")
    void sizeTest() {
        _Array<String> arr = arraySupplier.get();
        int index = 5;
        arr.add(index, SAMPLE_STRING);

        // проверка именно >=, т.к. impl может выделять элементы пачкой
        // т.к. индекс отсчитывается от 0, то capacity это index + 1
        Assertions.assertEquals(arr.size(), index + 1);
    }
}
