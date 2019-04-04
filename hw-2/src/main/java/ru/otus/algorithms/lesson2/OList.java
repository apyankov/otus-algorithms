package ru.otus.algorithms.lesson2;

/*********************************************************
 Пример использования:
 OList<Integer> l = new OList<Integer>();
 for(int i=0; i<10; i++)
 l.add(i*i);

 OList<Integer>.ListItem<Integer> li = l.head();
 while (li != null) {
 System.out.println(li.get());
 li = li.getNext();
 }
 *********************************************************/

public class OList<T> implements _List<T>{

    @SuppressWarnings("hiding")
    static class ListItem<T> implements _List._ListItem<T> {
        T _item;
        _List._ListItem<T> _next;

        ListItem(T item) {
            _item = item;
            _next = null;
        }

        public T get() {
            return _item;
        }

        @Override
        public void setNext(_ListItem<T> item) {
            _next = item;
        }

        public _List._ListItem<T> getNext() {
            return _next;
        }
    }

    _List._ListItem<T> _head;
    _List._ListItem<T> _tail;

    OList() {
        _head = null;
        _tail = null;
    }

    public _List._ListItem<T> head() {
        return _head;
    }

    @Override
    public void removeHead() {
        if(_head == null){
            throw new IllegalStateException("the list is empty, while attempt to remove head");
        }
        _head = _head.getNext();
    }

    public void add(T item) {
        ListItem<T> li = new ListItem<>(item);
        if (_head == null) {
            _head = li;
            _tail = li;
        }
        else {
            _tail.setNext(li);
            _tail = li;
        }
    }

    @Override
    public boolean isEmpty() {
        return _head == null;
    }
}
