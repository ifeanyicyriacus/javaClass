package datastructures;

import java.util.stream.IntStream;

public class InfiniteList extends InfiniteCollection{
    public InfiniteList() {
        this(2);
    }
    public InfiniteList(int capacity) {
        super(capacity);
    }
    public void remove(String element) {
        int elementIndex = indexOf(element);
        remove(elementIndex);
    }

    public void remove(int elementIndex) {
        if (elementIndex != -1) {
            for (int index = elementIndex; index < size; index++) {
                listBucket[index] = (index + 1 != size) ? listBucket[index + 1] : null;
            }
            size--;
        }
    }

    public void insert(int index, String element) {
        size++;
        for (int i = index; i < size; i++) {
            String temp = listBucket[i];
            listBucket[i] = element;
            element = temp;
        }
    }

    public int indexOf(String element) {
        for (int index = 0; index < size; index++) {
            if (element.equals(listBucket[index])){
                return index;
            }
        }
        return -1;
    }

    public String get(int index) {
        return listBucket[index];
    }

    public void add(String element) {
        ensureCapacity();
        listBucket[size] = element;
        size++;
    }

    public void replace(int index, String element) {
        listBucket[index] = element;
    }

    protected void ensureCapacity() {
        if (size == capacity) {
            int newCapacity = size * 2;
            String[] newList = new String[newCapacity];
            IntStream.range(0, size).forEach(i -> newList[i] = listBucket[i]);
            listBucket = newList;
            capacity = newCapacity;
        }
    }
}
