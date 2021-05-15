/*
 * Autores: Daniel Gonzalez Carrillo 20293, Marco Orozco 20857
 * Modificacion: 14/05/2021
 * Clase: HashTree
 * Descripcion:
 *      Clase que implementa un hashmap.
 */

import java.util.HashMap;

public class HashTree<K extends Comparable, V extends Comparable> implements Map<K, V>{
    //Data
    HashMap<K,V> data;

    public HashTree(){
        data = new HashMap<K, V>();
    }

    @Override
    public int size() {
        //Post: Retorna el tamaño del hashmap
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        //Post: Retorna si el hashmap esta vacio
        return data.isEmpty();
    }

    @Override
    public V get(K key) {
        //Post: Retorna el valor del hashmap dada una llave.
        if(isEmpty()){
            return null;
        }
        return data.get(key);
    }

    @Override
    public V put(K key, V value) {
        //Post: Guarda una llave y un valor.
        return data.put(key, value);
    }
}
