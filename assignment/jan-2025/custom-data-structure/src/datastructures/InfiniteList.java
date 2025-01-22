package datastructures;

import java.util.stream.IntStream;

public class InfiniteList extends InfiniteCollection {

    public void add(String element) {
        extendCapacity();
        listBucket[size] = element;
        size++;
    }

    public void remove(String element) {
        int elementIndex = indexOf(element);
        remove(elementIndex);
    }

    private void remove(int elementIndex) {
        if (elementIndex != -1) {
            for (int index = elementIndex; index < size; index++) {
                listBucket[index] = (index + 1 != size) ? listBucket[index + 1] : null;
            }
            size--;
        }
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

    public void insert(int index, String element) {
        size++;
        for (int i = index; i < size; i++) {
            String temp = listBucket[i];
            listBucket[i] = element;
            element = temp;
        }
    }
}
