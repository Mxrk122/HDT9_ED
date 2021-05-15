/*
 * Autores: Daniel Gonzalez Carrillo 20293, Marco Orozco 20857
 * Modificacion: 14/05/2021
 * Interfaz: Map
 * Descripcion:
 *      Interfaz que define las operaciones de un Map
 */


public interface Map<K,V> {

    //Post: Devuelve el tamaño de la estructura de datos.
    public int size();

    //Post: Devuelve si la estructura esta vacia o no.
    public boolean isEmpty();

    //Post: Obtiene un valor de la implementacion dada una llave.
    public V get(K k);

    //Post: Ingresa un nuevo valor a la implementacion
    public V put (K k, V v);
}
