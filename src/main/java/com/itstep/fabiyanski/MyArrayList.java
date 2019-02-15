package com.itstep.fabiyanski;

import java.util.Arrays;
import java.util.Random;

public class MyArrayList<T> implements ArrayList<T> {
    /* Я , как автор этого класса, посчитал нужным определить поля  следующим образом:
     size - это количество элементов массива, которые не равны null;
     capacity - это количество элементов массива, которые равны null*/
    private T[] data;
    private int size;
    private int capacity;

    public MyArrayList(int capacity) {
        setFields(capacity);
    }

    public MyArrayList() {
        setFields(10);
    }

    private void setFields(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * @return current amount of not null elements in the array
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the array of current elements
     */
    public T[] getData() {
        return data;
    }

    /**
     * @return current capacity of the array
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * <p>returns a copy of the array element at the specified index, with check for out of array</p>
     *
     * @param index the specified index
     * @return a copy of the array element at the specified  index
     */
    public T getElementAt(int index) {
        if (index >= 0 && index < data.length)
            return data[index];
        else System.out.println("Index is not correct!");
        return null;
    }

    /**
     * <p>creates an exact copy of "MyArrayList" object and returns a link to this copy.</p>
     *
     * @return a link to exact copy of "MyArrayList" object
     */
    public MyArrayList<T> clone() {
        MyArrayList<T> clonedMyArrayList = new MyArrayList<T>();
        clonedMyArrayList.size = getSize();
        clonedMyArrayList.data = getData();
        clonedMyArrayList.capacity = getCapacity();
        return clonedMyArrayList;
    }

    /* В методе toString() я специально включаю пустые элементы массива тоже,
чтобы в тестах нагляднее была видна работа методов. Если в нём убрать
комментарий, то пустые элементы в строку включаться не будут.*/

    /**
     * @return the line with all the elements of the array which separated by spaces
     */
    public String toString() {
        String string = new String();
        string = "";
        for (T element : data) {
            //if (element!=null)
            string = string + element + " ";
        }
        string.trim();//убирает пробел после последнего элемента
        return string;
    }

    private void ensureCapacity(int neededAmount) {
        while (neededAmount > capacity) {
            int newLength = (int) (data.length * 1.5 + 1);
            capacity = newLength - data.length;
            data = Arrays.copyOf(data, newLength);
        }
    }


    /**
     * <p> adds one element to the end of the array</p>
     *
     * @param element element that is added to the end of the array
     */
    public void pushBack(T element) {
        insert(data.length - 1, element);
    }

    /**
     * <p> deletes the first element of the array</p>
     */
    public void popFront() {
        removeAt(0);
    }

    /**
     * <p>adds new element to the array from its beginning</p>
     *
     * @param element element that is added to the beginning of the array
     */
    public void pushFront(T element) {
        insert(0, element);
    }

    //метод ниже ищет первый пустой элемент массива справа от индекса, в который нужно вставить новый элемент
    private int indexOfRightEmptyElement(int index) {
        int indexOfEmptyElement = -1;
        if (index != data.length - 1) {
            for (int i = index + 1; i < data.length; i++) {
                if (data[i] == null) {
                    indexOfEmptyElement = i;
                    break;
                }
            }
        }
        return indexOfEmptyElement;
    }

    //метод ниже ищет первый пустой элемент массива слева от индекса, в который нужно вставить новый элемент
    private int indexOfLeftEmptyElement(int index) {
        int indexOfEmptyElement = -1;
        if (index != 0) {
            for (int i = index - 1; i >= 0; i--) {
                if (data[i] == null) {
                    indexOfEmptyElement = i;
                    break;
                }
            }
        }
        return indexOfEmptyElement;
    }

/*Метод ниже вставляет новый элемент в массив.
Если этот элемент пустой, то ему просто присваивается новое значение.
Если же этот элемент не пустой, то происходит сдвиг элементов,которые расположены справа, на одну позицию вправо
при условии, что справа имеется хотя бы один пустой элемент.
Если пустого элемента справа нет, то происходит сдвиг элементов,которые находятся слева,  влево на одну позицию.
Пустая позиция или справа, или слева всегда будет в массиве, так как это достигается методом ensureCapacity.
    */

    /**
     * <p> adds a new element to the array</p>
     *
     * @param index   position of the new element in the array
     * @param element element that is added to  the array
     */
    public void insert(int index, T element) {
        if (index >= 0 && index < data.length) {
            if (data[index] != null) {
                ensureCapacity(1);
                if (indexOfRightEmptyElement(index) > 0) {
                    for (int i = indexOfRightEmptyElement(index); i > index; i--) {
                        data[i] = data[i - 1];
                    }
                } else {
                    for (int i = indexOfLeftEmptyElement(index); i < index; i++) {
                        data[i] = data[i + 1];
                    }
                }
            }
            data[index] = element;
            size = size + 1;
            capacity = capacity - 1;
        } else System.out.println("Index is incorrect!");
    }

    /**
     * <p>deletes one element from the array</p>
     *
     * @param index the index of the element that should be deleted
     */
    public void removeAt(int index) {
        if (index >= 0 && index < data.length) {
            if (data[index] != null) {
                data[index] = null;
                size = size - 1;
                capacity = capacity + 1;
            }
        } else System.out.println("Index is incorrect!");
    }

    /**
     * <p> deletes one element from the array</p>
     *
     * @param element the value of the element that should be deleted
     */
    public void remove(T element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) {
                removeAt(i);
                break;
            }
        }
    }

    /**
     * <p>deletes all the elements value of which is equal to the value of given parameter</p>
     *
     * @param element the value of the elements that should be deleted
     */
    public void removeAll(T element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) {
                removeAt(i);
            }
        }
    }

    /**
     * <p>deletes the last element of the array</p>
     */
    public void popBack() {
        removeAt(data.length - 1);
    }

    /**
     * <p>array zeroing - all elements of the array  are set to null, size field  assign value 0</p>
     */
    public void clear() {
        Arrays.fill(data, null);
        capacity = data.length;
        size = 0;
    }

    /**
     * @return true if size is 0, otherwise  false
     */
    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

/*У меня  метод ниже удаляет все элементы, которые равны null.
 Изначально условие написано двояко относительно значения поля capacity,
поэтому я, как автор этого класса, посчитал нужным сделать именно так.*/

    /**
     * <p>deletes all elements of the array that are null</p>
     */
    public void trimToSize() {
        capacity = 0;
        T[] newData = (T[]) new Object[size];
        int i = 0;
        for (T element : data) {
            if (element != null) {
                newData[i] = element;
                i++;
            }
        }
        data = newData;
    }

    /**
     * <p>searches from left to right for the first entry into the array of the specified value</p>
     *
     * @param element the specified value
     * @return the index of the item found, if the item is not found, it returns -1
     */
    public int indexOf(T element) {
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                if (data[i].equals(element)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    /**
     * p>searches from right to left  for the first entry into the array of the specified value</p>
     *
     * @param element the specified value
     * @return the index of the item found, if the item is not found, it returns -1
     */
    public int lastIndexOf(T element) {
        int index = -1;
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] != null) {
                if (data[i].equals(element)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    /**
     * <p>reorders all elements in the array on the opposite</p>
     */
    public void reverse() {
        T[] newData = (T[]) new Object[data.length];
        int i = data.length - 1;
        for (T element : data) {
            newData[i] = element;
            i--;
        }
        data = newData;
    }

    /**
     * <p>mixes the elements of the array randomly</p>
     */
    public void shuffle() {
        Random random = new Random();
        for (T element : data) {
            int index = random.nextInt(data.length);
            remove(element);
            insert(index, element);
        }
    }

// У меня метод ниже не учитывает пустые элементы при сравнении двух массивов.

    /**
     * <p>compares arrays not only by the number of elements, but also by their content</p>
     *
     * @param myArrayList link to another "MyArrayList" class object
     * @return true if arrays are equal, false if they are not
     */
    public boolean equals(MyArrayList<T> myArrayList) {
        MyArrayList<T> firstArrayList = clone();
        MyArrayList<T> secondArrayList = myArrayList.clone();
        firstArrayList.trimToSize();
        secondArrayList.trimToSize();
        if (firstArrayList.getSize() != secondArrayList.getSize())
            return false;
        else
            for (int i = 0; i < firstArrayList.getSize(); i++) {
                if (!firstArrayList.getElementAt(i).equals(secondArrayList.getElementAt(i))) {
                    return false;
                }
            }
        return true;
    }
}