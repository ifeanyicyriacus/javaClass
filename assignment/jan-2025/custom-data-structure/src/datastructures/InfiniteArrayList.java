package datastructures;

import java.util.stream.IntStream;

public class InfiniteArrayList extends InfiniteList {
    public InfiniteArrayList() {
        super();
    }
    public InfiniteArrayList(int capacity) {
        super(capacity);
    }

    public void add(String element) {
        extendCapacityIfNecessary();
        listBucket[size] = element;
        size++;
    }

    public int count(String element) {
        return (int) IntStream.range(0, size).filter(index -> element.equals(listBucket[index])).count();
    }

    public void removeAll(String element) {
        int count = count(element);
        System.out.println("Removing " + count + " elements");
        for (int index = 0; index < count; index++) {
            remove(element);
        }
    }

}
