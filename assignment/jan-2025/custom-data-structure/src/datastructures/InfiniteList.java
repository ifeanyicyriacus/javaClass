package datastructures;


import java.util.stream.IntStream;

public class InfiniteList {
    private int count = 0;
    private int capacity = 5;
    private String[] infiniteList = new String[capacity];

    public boolean isEmpty() {
        return count == 0;
    }

    public void add(String element) {
        ensureCapacity();
        infiniteList[count] = element;
        count++;
    }

    private void ensureCapacity() {
        if (count == capacity) {
            int newCapacity = count * 2;
            String[] newList = new String[newCapacity];
            IntStream.range(0, newCapacity).forEach(i -> newList[i] = infiniteList[i]);
            infiniteList = newList;
            capacity = newCapacity;
        }
    }

    public int size() {
        return count;
    }

    public boolean contains(String element) {
        return IntStream.range(0, count).anyMatch(index -> element.equals(infiniteList[index]));
    }

    public void remove(String element) {
        int elementIndex = indexOf(element);
        remove(elementIndex);
    }

    private void remove(int elementIndex) {
        if (elementIndex != -1) {
            for (int index = elementIndex + 1; index < count; index++) {
                infiniteList[index] = infiniteList[index - 1];
            }
            count--;
        }
    }

    private int indexOf(String element) {
        for (int index = 0; index < count; index++) {
            if (infiniteList[index].equals(element)){
                return index;
            }
        }
        return -1;
    }


    public String get(int index) {
        return infiniteList[index];
    }
}
