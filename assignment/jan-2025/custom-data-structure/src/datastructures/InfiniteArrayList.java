package datastructures;

public class InfiniteArrayList extends InfiniteList {
    public InfiniteArrayList() {
        this(2);
    }
    public InfiniteArrayList(int capacity) {
        super(capacity);
    }

    public void add(String element) {
        ensureCapacity();
        listBucket[size] = element;
        size++;
    }

    public void removeAll(String element) {
        int count = count(element);
        for (int index = 0; index < count; index++) {
            remove(element);
        }
    }

}
