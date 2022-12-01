package com.skypro.arraylist.service;

import com.skypro.arraylist.exception.*;
import java.util.Arrays;


public class ArrayListService implements StringList{
    private final String[] list;
    private  int size;

    public ArrayListService(int size) {
        list = new String[size];
    }

    @Override
    public String add(String item) {
        if (size >= list.length) {
            throw new FullListException("Массив заполнен.");
        }
        if (item == null) {
            throw new InCorrectElementException("Вы ввели пустую строку");
        }
        list[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index >= list.length || index > size){
            throw new ExceedsLengthException("Выходит за пределы массива");
        }
        if (size == list.length) {
            throw new FullListException("Массив заполнен.");
        }
        list[index] = item;
        return list[index];
    }

    @Override
    public String set(int index, String item) {
        if (index > size || index > list.length) {
            throw new ExceedsLengthException("Выходит за пределы массива");
        }
        list[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new InCorrectElementException("Вы ввели пустую строку");
        }
        if (indexOf(item) == -1) {
            throw new NotElementException("Элемент не найден");
        }
        if (indexOf(item) != size) {
            System.arraycopy(list, indexOf(item) + 1,list, indexOf(item), size - indexOf(item));
        }
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        if (index == -1){
            throw new NotElementException("Элемент не найден");
        }
        String item = list[size];
        if (index != size){
            System.arraycopy(list, index + 1,list, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size -1; i >= 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= list.length || index > size) {
            throw new ExceedsLengthException("Выходит за пределы массива");
        }
        return list[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new EmptyListException("Пустой массив");
        }
        if (this.size == otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!list[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(list, size);
    }
}
