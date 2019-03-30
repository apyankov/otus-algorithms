package ru.otus.algorithms.lesson2;

/**
 * _Array impl, в которой:
 * - используем список блоков (массивов)
 * - блоки заполняем последовательно, но не-полностью - так, чтобы оставалось место для вставок
 * - при расширении массива - добавляем блок
 */
public class IArray<T> implements _Array<T> {

    private OList<T[]> _rowsList;
    private int blockSize;

    /**
     * Используем только в этом классе,
     * но, чтобы протестировать - делаем доступ package
     */
    static int rowsCount(int initialSize, int blockSize){
        return -1;
    }
    @SuppressWarnings("unchecked")
    static <T> OList<T[]> initialList(int initialSize, int blockSize){
        return null;
    }

    public IArray() {
        this(10,10);
    }

    /**
     * @param initialSize - начальный размер массива. То есть, size >= этого значения
     * @param blockSize - размер блоков. То есть, с каким шагом будет расширяться массив
     */
    public IArray(int initialSize, int blockSize) {
        this.blockSize = blockSize;
        this._rowsList = initialList(initialSize, blockSize);
    }


    public T get(int index) {
        return null;
    }

    public void add(int index, T element) {

    }

    public void set(int index, T element) {

    }

    public int size() {
        return 0;
    }

    private int rowOf(int index){
        return -1;
    }

    private int columnOf(int index){
        return -1;
    }
}