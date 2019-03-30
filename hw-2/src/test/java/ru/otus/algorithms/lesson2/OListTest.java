package ru.otus.algorithms.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OListTest {

    private static final int VALUE_1 = 10;
    private static final int VALUE_2 = 20;

    @Test
    @DisplayName("OList, добавленные элементы - доступны для считывания")
    void basicTest(){
        OList<Integer> list = new OList<Integer>();
        list.add(VALUE_1);
        list.add(VALUE_2);

        OList<Integer>.ListItem<Integer> element1 = list.head();
        OList<Integer>.ListItem<Integer> element2 = element1.getNext();
        OList<Integer>.ListItem<Integer> element3 = element2.getNext();

        Assertions.assertEquals(VALUE_1, (int) element1.get());
        Assertions.assertEquals(VALUE_2, (int) element2.get());
        Assertions.assertNull(element3);
    }
}
