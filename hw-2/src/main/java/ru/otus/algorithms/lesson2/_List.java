package ru.otus.algorithms.lesson2;

/**
 * Список, интерфейс/методы, которые требуются по заданию (урок 2)
 */
public interface _List<T> {

    /**
     * Элемент списка - обертка к объекту, который помещаем в список
     */
    static interface _ListItem<T> {
        /**
         * получить объект
         */
        T get();

        /**
         * Установить, какой элемент будет следующим
         */
        void setNext(_ListItem<T> item);

        /**
         * Получить следующий элемент
         */
        _ListItem<T> getNext();
    }

    /**
     * Получить первый элемент в списке
     */
    _ListItem<T> head();

    /**
     * Удалить первый элемент в списке
     * @throws IllegalStateException - если список пустой
     */
    void removeHead();

    /**
     * Добавить элемент в конец списка
     */
    void add(T item);

    /**
     * Если список путой - вернет true
     */
    boolean isEmpty();
}
