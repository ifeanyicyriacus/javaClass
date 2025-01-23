package datastructures;

public class InfiniteSet extends InfiniteList {

    public void add(String element) {
        if (!contains(element)) {
            extendCapacityIfNecessary();
            listBucket[size] = element;
            size++;
        }
    }

//    get interset,difference, union set, issubset, issuperset
}
