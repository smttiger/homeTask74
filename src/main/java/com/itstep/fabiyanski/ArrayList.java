package com.itstep.fabiyanski;

public interface ArrayList<T> {
    int getSize();

    String toString();

    void pushBack(T element);

    void popFront();

    void pushFront(T element);

    void insert(int index, T element);

    void removeAt(int index);

    void remove(T element);

    void removeAll(T element);

    void popBack();

    void clear();

    boolean isEmpty();

    void trimToSize();

    int indexOf(T element);

    int lastIndexOf(T element);

    void reverse();

    void shuffle();

    boolean equals(MyArrayList<T> myArrayList);

    T[] getData();

    T getElementAt(int index);

    MyArrayList<T> clone();

    int getCapacity();

}
