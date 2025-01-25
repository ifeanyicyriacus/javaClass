package datastructures;

public class InfiniteSet extends InfiniteList {

    public void add(String element) {
        if (!contains(element)) {
            super.add(element);
        }
    }

    public void add(String[] elements) {
        for (String element : elements) {
            add(element);
        }
    }

    @Override
    public int count(String text) {
        for (String element: listBucket){
            if (text.equals(element)){ return 1; }
        }
        return 0;
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
