public class Association<K extends Comparable, V> implements Comparable<Association<K,V>>{
    public K key;
    private V value;

    public Association(K k, V v){
        key = k;
        value = v;
    }

    public K getKey(){
        return key;
    }

    public V getValue(){
        return value;
    }

    @Override
    public int compareTo(Association<K, V> o) {
        return key.compareTo(o.getKey());
    }
}
