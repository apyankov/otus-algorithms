package ru.otus.algorithms.lesson2;

/*********************************************************
 _Array impl, в которой:
    - используем один массив, который при расширении - заменяем на массив большего размера

 Пример использования:

 DArray<Integer> a = new DArray<Integer>();

 Date start = new Date();
 for(int i=0; i<10; i++)
 a.add(i,i*i);

 for(int i=0; i<10; i++)
 System.out.println(a.get(i));
 *********************************************************/

class DArray<T> implements _Array<T> {

    private T[] _arr;
    private int growBlockSize;


    DArray() {
        this(0, 1);
    }

    @SuppressWarnings("unchecked")
    DArray(int initialSize, int growBlockSize) {
        assert initialSize >= 0;
        assert growBlockSize > 0;

        if (initialSize > 0) {
            this._arr = (T[]) new Object[initialSize];
        }
        this.growBlockSize = growBlockSize;
    }


    public T get(int index) {
        return _arr[index];
    }

    public void add(int index, T element) {
        if (_arr == null || _arr.length <= index)
            relocate(index + growBlockSize, index);
        _arr[index] = element;
    }

    public void set(int index, T element) {
        _arr[index] = element;
    }

    public int size() {
        return _arr.length;
    }


    @SuppressWarnings("unchecked")
    private void relocate(int newsize, int index) {
        T[] tmp = (T[]) new Object[newsize];

        if (_arr != null)
            for (int i = 0; i < _arr.length; i++)
                if (i < index)
                    tmp[i] = _arr[i];
                else
                    tmp[i + 1] = _arr[i];
        _arr = tmp;
    }
}
