package ru.otus.algorithms.lesson2;

/**
 * PQueue impl через массив списков
 */
public class PQueueImpl<T> implements PQueue<T> {

    // индекс в массиве - приоритет,
    // элемент массива - список элементов, которые добавлены с этим приоритетом
    private _Array<OList<T>> _priorArr;


    public PQueueImpl() {
        this._priorArr = new DArray<>();
    }


    @Override
    public void enqueue(int priority, T item) {
        OList<T> priorityQueue = guaranteeObtainElement(priority);
        priorityQueue.add(item); // т.к. FIFO - добавляем в хвост, забирать будем head
    }

    /**
     * Найти список с таким приоритетом, если такого нет - создать
     */
    private OList<T> guaranteeObtainElement(int priority) {
        if (_priorArr.size() < priority + 1) {
            OList<T> result = new OList<>();
            _priorArr.add(priority, result);
            return result;
        } else {
            OList<T> result = _priorArr.get(priority);
            if (result == null) {
                result = new OList<>();
                _priorArr.set(priority, result);
            }
            return result;
        }
    }

    @Override
    public T dequeue() {
        // найти не-пустой список с max приоритетом
        for (int i = _priorArr.size() - 1; i >= 0; i--) {
            _List<T> elem = _priorArr.get(i);
            if (elem != null && !elem.isEmpty()) { // список есть и не-пустой
                _List._ListItem<T> head = elem.head();
                T result = head.get();
                elem.removeHead();
                return result;
            }
        }
        return null;
    }
}
