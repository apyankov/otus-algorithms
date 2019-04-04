package ru.otus.algorithms.lesson2;

/**
 * _Array impl, в которой:
 * - используем массив блоков (массивов)
 * - блоки заполняем последовательно
 * - при расширении массива - добавляем блок
 */
public class BArray<T> implements _Array<T> {

    private T[][] _arr;
    private int blockSize;

    /**
     * Используем только в этом классе,
     * но, чтобы протестировать - делаем доступ package
     */
    static int rowsCount(int initialSize, int blockSize) {
        if (initialSize < 0)
            throw new IllegalArgumentException(String.format("initialSize should be >= 0, but it is: %s", initialSize));
        if (blockSize <= 0)
            throw new IllegalArgumentException(String.format("blockSize should be > 0, but it is: %s", initialSize));

        if(initialSize == 0)
            return 0;
        else if(initialSize <= blockSize)
            return 1;
        else {
            int tail = initialSize % blockSize == 0 ? 0 : 1;
            return tail + initialSize / blockSize;
        }
    }

    static int rowOf(int index, int blockSize) {
        return -1;
    }

    static int columnOf(int index, int blockSize) {
        return -1;
    }
    @SuppressWarnings("unchecked")
    static <T> T[][] initialArray(int initialSize, int blockSize) {
        return (T[][]) new Object[rowsCount(initialSize, blockSize)][];
    }

    public BArray() {
        this(10, 10);
    }

    /**
     * @param initialSize - начальный размер массива. То есть, size >= этого значения
     * @param blockSize   - размер блоков. То есть, с каким шагом будет расширяться массив
     */
    public BArray(int initialSize, int blockSize) {
        this.blockSize = blockSize;
        this._arr = initialArray(initialSize, blockSize);
    }


    public T get(int index) {
        if(index < 0 || index > size() - 1){
            throw new IndexOutOfBoundsException(String.format("index specified: %s, while should be in range: 0 - %s", index, size() - 1));
        }
        int row = rowOf(index);
        int column = columnOf(index);
        return _arr[row][column];
    }

    public void add(int index, T element) {

    }

    public void set(int index, T element) {

    }

    public int size() {
        return 0;
    }

    private int rowOf(int index) {
        return rowOf(index, blockSize);
    }

    private int columnOf(int index) {
        return columnOf(index, blockSize);
    }
}