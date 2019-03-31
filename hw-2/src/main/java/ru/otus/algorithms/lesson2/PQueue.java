package ru.otus.algorithms.lesson2;

/**
 * Очередь с приоритетом
 */
interface PQueue<T> {

    /**
     * поместить элемент в очередь
     * @param priority - чем приоритет выше - тем быстрее очередь его выдает
     * @param item - элемент для добавления. Не null
     * @throws IllegalMonitorStateException - если добавляем null
     */
    void enqueue(int priority, T item);

    /**
     * выбрать элемент из очереди
     * @return - элемент с top-приоритетом, FIFO. null - если элементов в очереди нет
     */
    T dequeue();
}
