package datastructures;

import java.util.stream.IntStream;

public class InfiniteCollection {
    protected int size     = 0;
    protected int capacity;
    protected String[] listBucket;

    public InfiniteCollection(int capacity) {
        this.capacity = capacity;
        listBucket = new String[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
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

    public int size() {
        return size;
    }

    public boolean contains(String element) {
        return IntStream.range(0, size).anyMatch(index -> element.equals(listBucket[index]));
    }

    public void clear(){
        listBucket = new String[capacity];
        size = 0;
    }

    private String[] trimToSize(String[] listBucket) {
        String[] newList = new String[size];
        System.arraycopy(listBucket, 0, newList, 0, size);
        return newList;
    }

    public String[] toArray() {
        return trimToSize(listBucket);
    }

    public int count(String element) {
        return (int) IntStream.range(0, size)
                .filter(index -> element.equals(listBucket[index]))
                .count();
    }

//    public InfiniteCollection sort() {
//        return null;
//    }
//
//    public InfiniteCollection reverse() {
//        return null;
//    }
//
//    public InfiniteCollection shuffle() {
//        return null;
//    }
//
//    public InfiniteCollection shuffle(Random random) {
//        return null;
//    }
//
//    public InfiniteCollection copy() {
//        return null;
//    }
}
