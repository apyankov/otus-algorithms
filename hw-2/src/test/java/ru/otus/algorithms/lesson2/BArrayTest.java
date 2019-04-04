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
        Assertions.assertEquals(0, BArray.rowsCount(0, 1));
        Assertions.assertEquals(1, BArray.rowsCount(2, 2));
        Assertions.assertEquals(2, BArray.rowsCount(6, 3));
        Assertions.assertEquals(5, BArray.rowsCount(5, 1));
        Assertions.assertEquals(3, BArray.rowsCount(5, 2));
    }

    @Test
    @DisplayName("BArray.rowOf вычисляет значение корректно")
    void rowOfTest() {
        Assertions.assertEquals(0, BArray.rowOf(0, 1));
    }

    @Test
    @DisplayName("BArray.columnOf вычисляет значение корректно")
    void columnOfTest() {
        Assertions.assertEquals(0, BArray.columnOf(0, 1));
    }
}
