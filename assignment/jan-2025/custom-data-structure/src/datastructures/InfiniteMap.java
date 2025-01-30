package datastructures;

public class InfiniteMap{
    private final InfiniteSet       keys;
    private final InfiniteArrayList values;

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
        if(keys.contains(key)) {
            int index = keys.indexOf(key);
            values.replace(index, value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    public String get(String key) {
        int index = keys.indexOf(key);
        if(index != -1) {
            return values.get(index);
        }
        return null;
    }

    public String[] keys() { return keys.toArray();}

    public String[] values() { return values.toArray();}

    public void remove(String key) {
        int index = keys.indexOf(key);
        if(index != -1) {
            keys.remove(index);
            values.remove(index);
        }
    }

    public String[][] items() {
        String[][] items = new String[size()][];
        for(int index = 0; index < size(); index++) {
            items[index] = new String[] {
                    keys.get(index), values.get(index)
            } ;
        }
        return items;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (int index = 0; index < size(); index++) {
            result.append("\t\"").append(keys.get(index)).append("\": \"").append(values.get(index)).append("\",\n");
        }
        result.append("}\n");
        return result.toString();
    }
}
