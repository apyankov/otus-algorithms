package ru.otus.algorithms.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class OListTest {

    private static final int VALUE_1 = 10;
    private static final int VALUE_2 = 20;

    private _List<Integer> list = new OList<>();

    @Test
    @DisplayName("OList, добавленные элементы - доступны для считывания")
    void basicTest() {
        list.add(VALUE_1);
        list.add(VALUE_2);

        _List._ListItem<Integer> element1 = list.head();
        _List._ListItem<Integer> element2 = element1.getNext();
        _List._ListItem<Integer> element3 = element2.getNext();

        Assertions.assertEquals(VALUE_1, (int) element1.get());
        Assertions.assertEquals(VALUE_2, (int) element2.get());
        Assertions.assertNull(element3);
    }

    @Test
    @DisplayName("OList, удаление head - работает")
    void removeHeadTest() {
        list.add(VALUE_1);
        list.add(VALUE_2);

        // когда остаются элементы после удаления
        list.removeHead();
        Assertions.assertEquals(VALUE_2, (int) list.head().get());

        // когда удаляем последний элемент
        list.removeHead();
        Assertions.assertNull(list.head());

        // когда пробуем удалить head из пустого списка
        Assertions.assertThrows(IllegalStateException.class, () -> list.removeHead());
    }

    @Test
    @DisplayName("OList, isEmpty - работает")
    void isEmptyTest() {
        // пустой - возвращает true
        Assertions.assertTrue(list.isEmpty());

        // не-пустой - возвращает false
        list.add(VALUE_1);
        Assertions.assertFalse(list.isEmpty());

        // нет гистерезиса. То есть, когда удалили элемент - список пустой
        list.removeHead();
        Assertions.assertTrue(list.isEmpty());
    }
}
