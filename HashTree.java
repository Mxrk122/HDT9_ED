import java.util.HashMap;

public class HashTree<K extends Comparable, V extends Comparable> implements Map<K, V>{
    //Data
    HashMap<K,V> data;

    public HashTree(){
        data = new HashMap<K, V>();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return data.isEmpty()
    }

    @Override
    public V get(K key) {
        // TODO Auto-generated method stub
        return data.get(key);
    }

    @Override
    public V put(K key, V value) {
        // TODO Auto-generated method stub
        return data.put(key, value);
    }
}
