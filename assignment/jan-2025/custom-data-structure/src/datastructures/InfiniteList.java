package datastructures;

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
                listBucket[index] = listBucket[index - 1];
            }
            size--;
        }
    }





}
