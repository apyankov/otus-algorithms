package ru.otus.algorithms.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class BArrayTest extends _ArrayBaseTest {

    BArrayTest() { // подключаем базовые тесты для _Array
        super(BArray::new);
    }

    @Test
    @DisplayName("BArray.elementsCount вычисляет значение корректно")
    void rowsCountTest() {
        Assertions.assertEquals(0, BArray.Functions.rowsCount(0, 1));
        Assertions.assertEquals(1, BArray.Functions.rowsCount(2, 2));
        Assertions.assertEquals(2, BArray.Functions.rowsCount(6, 3));
        Assertions.assertEquals(5, BArray.Functions.rowsCount(5, 1));
        Assertions.assertEquals(3, BArray.Functions.rowsCount(5, 2));
    }

    @Test
    @DisplayName("BArray.rowOf вычисляет значение корректно")
    void rowOfTest() {
        Assertions.assertEquals(0, BArray.Functions.rowOf(0, 1));
    }

    @Test
    @DisplayName("BArray.columnOf вычисляет значение корректно")
    void columnOfTest() {
        Assertions.assertEquals(0, BArray.Functions.columnOf(0, 1));
    }

    @Test
    @DisplayName("initialArray() создает корректный массив")
    void initialArrayTest() {
        // массив нулевой длины
        Object[][] arr0 = BArray.Functions.initialArray(0,10);
        Assertions.assertEquals(0, arr0.length);

        // initialSize < blockSize
        Object[][] arr1 = BArray.Functions.initialArray(7,10);
        Assertions.assertEquals(1, arr1.length);
        Assertions.assertEquals(10, arr1[0].length);

        // initialSize = blockSize
        Object[][] arr2 = BArray.Functions.initialArray(10,10);
        Assertions.assertEquals(1, arr2.length);
        Assertions.assertEquals(10, arr2[0].length);

        // initialSize > blockSize
        Object[][] arr3 = BArray.Functions.initialArray(30,20);
        Assertions.assertEquals(2, arr3.length);
        Assertions.assertEquals(20, arr3[0].length);
    }
}
