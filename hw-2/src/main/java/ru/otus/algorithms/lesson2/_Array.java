package ru.otus.algorithms.lesson2;

public interface _Array<T> {
    /**
     * Получить элемент по индексу
     * @return - элемент, который по этому индексу, либо null
     * @throws ArrayIndexOutOfBoundsException - если index выходит за пределы массива
     */
    T get(int index);

    /**
     * Добавить элемент по указанному индексу.
     * Если index выходит за пределы массива - массив будет расширен таким образом, чтобы элемент был доступен
     * @throws ArrayIndexOutOfBoundsException - если index < 0
     */
    void add(int index, T element);

    /**
     * Устанавливает элемент массива по указанному индексу.
     * Только для тех индексов, которые в пределах массива
     * @throws ArrayIndexOutOfBoundsException - если index выходит за пределы массива
     */
    void set(int index, T element);

    /**
     * Актуальный размер массива - то есть, сколько элементов выделено.
     * Пределы массива - считаются от 0 до size-1
     */
    int size();
}
