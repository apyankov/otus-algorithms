package ru.otus.algorithms.lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class PQueueTest {

    private static final String SAMPLE_VALUE_1 = "sample string 1";
    private static final String SAMPLE_VALUE_2 = "sample string 2";
    private static final String SAMPLE_VALUE_3 = "sample string 3";

    private PQueue<String> queue = new PQueueImpl<>();


    @Test
    @DisplayName("dequeue возвращает то, что было enqueue")
    void insertDataTest(){
        queue.enqueue(1, SAMPLE_VALUE_1);
        String restored = queue.dequeue();

        Assertions.assertEquals(SAMPLE_VALUE_1, restored);
    }

    @Test
    @DisplayName("dequeue возвращает null, когда пусто")
    void dequeueNullTest(){
        // если dequeue - это первый вызов
        String value1 = queue.dequeue();
        Assertions.assertNull(value1);

        // при уменьшении очереди
        queue.enqueue(1, SAMPLE_VALUE_1);
        queue.dequeue();
        String value2 = queue.dequeue();
        Assertions.assertNull(value2);

        // при повторных dequeue на пустой очереди
        String value4 = queue.dequeue();
        Assertions.assertNull(value4);
    }

    @Test
    @DisplayName("в пределах одного приоритета - элементы возвращаем FIFO")
    void samePriorityTest() {
        queue.enqueue(10, SAMPLE_VALUE_1);
        queue.enqueue(10, SAMPLE_VALUE_2);
        queue.enqueue(10, SAMPLE_VALUE_3);
        String restored1 = queue.dequeue();
        String restored2 = queue.dequeue();
        String restored3 = queue.dequeue();

        Assertions.assertEquals(SAMPLE_VALUE_1, restored1);
        Assertions.assertEquals(SAMPLE_VALUE_2, restored2);
        Assertions.assertEquals(SAMPLE_VALUE_3, restored3);
    }

    @Test
    @DisplayName("dequeue возвращает значение, с учетом приоритета")
    void priorityInActionTest() {
        queue.enqueue(2, SAMPLE_VALUE_1); // середина
        queue.enqueue(3, SAMPLE_VALUE_2); // топ
        queue.enqueue(1, SAMPLE_VALUE_3); // хвост
        String restored1 = queue.dequeue(); // топ
        String restored2 = queue.dequeue(); // середина
        String restored3 = queue.dequeue(); // хвост

        Assertions.assertEquals(SAMPLE_VALUE_2, restored1);
        Assertions.assertEquals(SAMPLE_VALUE_1, restored2);
        Assertions.assertEquals(SAMPLE_VALUE_3, restored3);
    }
}
