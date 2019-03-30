package ru.otus.algorithms.lesson2;

class IArrayTest extends _ArrayTest {

    IArrayTest() { // подключаем базовые тесты для _Array
        super(BArray::new);
    }

}
