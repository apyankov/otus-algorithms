package ru.otus.algorithms.lesson2;

/**
 * PQueue impl через массив списков
 */
public class PQueueImpl<T> implements PQueue<T> {

    private OList<T>[] _queue; // индекс в массиве - приоритет, элемент массива - список элементов с этим приоритетом


    @SuppressWarnings("unchecked")
    public PQueueImpl() {
        this._queue = (OList<T>[])new OList[0];
    }


    @Override
    public void enqueue(int priority, T item) {
        // найти список с таким приоритетом, если такого нет - создать
        guaranteeElement(priority);
        OList<T> priorityQueue = _queue[priority];
        if(priorityQueue == null){
            priorityQueue = new OList<>();
        }
        priorityQueue.add(item);
    }

    @SuppressWarnings("unchecked")
    private void guaranteeElement(int priority){
        if(_queue.length < priority){
            // создаем и заполняем новый _queue
            OList<T>[] newQueue = (OList<T>[])new OList[priority + 1];
        }
    }

    @Override
    public T dequeue() {
        // найти список с max приоритетом

        // взять хвост

        return null;
    }
}
