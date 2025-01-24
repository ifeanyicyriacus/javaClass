package datastructures;

public class InfiniteSet extends InfiniteList {

    public void add(String element) {
        if (!contains(element)) {
            ensureCapacity();
            listBucket[size] = element;
            size++;
        }
    }

//    @Override
    public int count(String element) {
        return 1;
    }

//    public InfiniteSet intersection(InfiniteSet other) {
//        return null;
//    }
//
//    public InfiniteSet union(InfiniteSet other) {
//        return null;
//    }
//
//    public InfiniteSet difference(InfiniteSet other) {
//        return null;
//    }
//
//    public boolean isSuperset(InfiniteSet other) {
//        return false;
//    }
//
//    public boolean isSubset(InfiniteSet other) {
//        return false;
//    }
}
