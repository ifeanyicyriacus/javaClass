package datastructures;

public class InfiniteMap{
    private InfiniteSet keys;
    private InfiniteArrayList values;

    public InfiniteMap() {
        keys = new InfiniteSet();
        values = new InfiniteArrayList();
    }

    public boolean isEmpty() {
        return keys.isEmpty() && values.isEmpty();
    }

    public int capacity() {
        return keys.capacity;
    }

    public int size() {
        return keys.size();
    }

    public void add(String key, String value) {

        //if key exist find its index overwrite arraylist value - this might warrant an overite method
        keys.add(key);
        values.add(value);
    }
}
