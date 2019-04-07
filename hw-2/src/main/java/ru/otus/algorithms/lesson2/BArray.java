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
     * @param initialSize - начальный размер массива. То есть, size >= этого значения
     * @param blockSize   - размер блоков. То есть, с каким шагом будет расширяться массив
     */
    @SuppressWarnings("unchecked")
    public BArray(int initialSize, int blockSize) {
        this.blockSize = blockSize;
        this._arr = (T[][])Functions.initialArray(initialSize, blockSize);
    }

    public BArray() {
        this(10, 10);
    }


    public T get(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException(String.format("index specified: %s, while should be in range: 0 - %s", index, size() - 1));
        }
        int row = rowOf(index);
        int column = columnOf(index);
        return _arr[row][column];
    }

    public void add(int index, T element) {
        guaranteeIndex(index);
        set(index, element);
    }

    public void set(int index, T element) {
        _arr[rowOf(index)][columnOf(index)] = element;
    }

    public int size() {
        return _arr.length * blockSize;
    }

    /**
     * после вызова - гарантированно есть ячейка для такого индекса. То есть, дополняем блоки
     */
    @SuppressWarnings("unchecked")
    private void guaranteeIndex(int index) {
        int requiredCount = rowOf(index);
        int currentCount = _arr.length;
        if (requiredCount > currentCount) {
            T[][] newArr = (T[][]) new Object[requiredCount][];
            for (int i = 0; i < currentCount; i++) {
                newArr[i] = _arr[i];
            }
            for (int i = currentCount; i < requiredCount; i++) {
                newArr[i] = (T[]) new Object[blockSize];
            }
            _arr = newArr;
        }
    }

    private int rowOf(int index) {
        return Functions.rowOf(index, blockSize);
    }

    private int columnOf(int index) {
        return Functions.columnOf(index, blockSize);
    }

    static class Functions {
        /**
         * Используем только в этом классе,
         * но, чтобы протестировать - делаем доступ package
         */
        static int rowsCount(int initialSize, int blockSize) {
            if (initialSize < 0)
                throw new IllegalArgumentException(String.format("initialSize should be >= 0, but it is: %s", initialSize));
            if (blockSize <= 0)
                throw new IllegalArgumentException(String.format("blockSize should be > 0, but it is: %s", initialSize));

            if (initialSize == 0)
                return 0;
            else if (initialSize <= blockSize)
                return 1;
            else {
                int tail = initialSize % blockSize == 0 ? 0 : 1;
                return tail + initialSize / blockSize;
            }
        }

        static int rowOf(int index, int blockSize) {
            return index / blockSize;
        }

        static int columnOf(int index, int blockSize) {
            return index % blockSize;
        }

        static Object[][] initialArray(int initialSize, int blockSize) {
            Object[][] result = new Object[Functions.rowsCount(initialSize, blockSize)][];
            for(int i=0; i<result.length; i++){
                result[i] = new Object[blockSize];
            }
            return result;
        }
    }
}