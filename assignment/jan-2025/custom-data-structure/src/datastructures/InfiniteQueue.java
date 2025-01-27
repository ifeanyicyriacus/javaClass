package datastructures;

public class InfiniteQueue extends InfiniteCollection {
//    private boolean isFixedCapacity;
    private int pointer = 0;
    private int count = 0;

    public InfiniteQueue(int capacity) {
        super(capacity);
    }

    @Override
    public boolean isFull() {
        return listBucket[(size % capacity)] != null;
    }

    @Override
    public boolean isEmpty() {
        for (String element : listBucket) {
            if (element != null) {return false;}
        }
        return true;
    }

    @Override
    public int size() {
        return count;
    }

    public void add(String element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full: element cannot be added at this time due to capacity " +
                    "restrictions");
        } else {
            listBucket [(size % capacity)] = element;
            size++; count++;
        }
    }
    //    offer

    public String peek() {
        return listBucket [pointer % capacity];
    }

    public String remove() {
        if (!isEmpty()) {
            String element = listBucket [pointer % capacity];
            listBucket [(pointer % capacity)] = null;
            pointer++;
            count--;
            return element;
        } else {
            return null;
        }
    }
//    poll


}
