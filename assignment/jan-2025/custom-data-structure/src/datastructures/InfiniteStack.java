package datastructures;

public class InfiniteStack extends InfiniteCollection{
    public InfiniteStack(int capacity) {
        super(capacity);
    }

    public void push(String element) {
        if(isFull()) {
            throw new RuntimeException("Stack is full");
        }else {
            listBucket[size] = element;
            size++;
        }
    }

    public String pop() {
        String result = null;
        if(!isEmpty()) {
            result = listBucket[size - 1];
            listBucket[size - 1] = "";
            size--;
        }
        return result;
    }

    public String peek() {
        return listBucket[size - 1];
//        return null if not included in test whe
    }
}
