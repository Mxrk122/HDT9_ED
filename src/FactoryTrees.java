/*
 * Autores: Daniel Gonzalez Carrillo 20293, Marco Orozco 20857
 * Modificacion: 14/05/2021
 * Clase: FactoryTrees
 * Descripcion:
 *      Clase que permite generar una implementacion del map dependiendo de la eleccion del usuario.
 */

public class FactoryTrees<K extends Comparable, V extends Comparable>{
    private Map TreeMap;

    public Map<K,V> createTree(int option){
        //Post: Se devuelve una implementacion de un map elegido por el usuario.
        if(option==1){
            TreeMap = new HashTree<K, V>();
        }
        else {
            TreeMap = new SplayTreeMap<K, V>();
        }

        return TreeMap;
    }
}

