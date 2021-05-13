public interface Map<K,V> {

    public int size();

    public boolean isEmpty();

    public V get(K k);

    public V put (K k, V v);

    public boolean equals(Object other);
}
