package datastructures;

import java.util.stream.IntStream;

public class InfiniteCollection {
    protected int size     = 0;
    protected int capacity;
    protected String[] listBucket;

    public InfiniteCollection() {
        capacity = 2;
        listBucket = new String[capacity];
    }
    public InfiniteCollection(int capacity) {
        this.capacity = capacity;
        listBucket = new String[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    protected void extendCapacity() {
        if (size == capacity) {
            int newCapacity = size * 2;
            String[] newList = new String[newCapacity];
            IntStream.range(0, size).forEach(i -> newList[i] = listBucket[i]);
            listBucket = newList;
            capacity = newCapacity;
        }
    }
    
    protected int size() {
        return size;
    }

    protected boolean contains(String element) {
        return IntStream.range(0, size).anyMatch(index -> element.equals(listBucket[index]));
    }

    protected int indexOf(String element) {
        for (int index = 0; index < size; index++) {
            if (element.equals(listBucket[index])){
                return index;
            }
        }
        return -1;
    }

    protected String get(int index) {
        return listBucket[index];
    }

    protected void clear(){
        listBucket = new String[capacity];
        size = 0;
    }

    private String[] trimToSize(String[] listBucket) {
        String[] newList = new String[size];
        System.arraycopy(listBucket, 0, newList, 0, size);
        return newList;
    }

    protected String[] toArray() {
        return trimToSize(listBucket);
    }

//    implement reverse, sort and copy
}
