/*
 * Autores: Daniel Gonzalez Carrillo 20293, Marco Orozco 20857
 * Modificacion: 14/05/2021
 * Clase: SplayTreeMap
 * Descripcion:
 *      Clase que implementa un splaytree para el balance de un arbol binario de busqueda.
 */


public class SplayTreeMap<K extends Comparable, V> implements Map<K, V> {

    private BinaryTree<Association<K,V>> root;
    private BinaryTree<Association<K,V>> EMPTY = new BinaryTree<Association<K,V>>();
    private int size;

    //Constructores
    public SplayTreeMap(K k, V v){
        size = 0;
        Association<K,V> association = new Association<K,V>(k, v);
        root = new BinaryTree<Association<K,V>>(association);
    }

    public SplayTreeMap(){
        size = 0;
        root = EMPTY;
    }

    //Metodo que obtiene un valor del map si existe.
    public V get(K k){
        //Si la raiz del arbol esta vacia, no hay ningun elemento.
        if(root.isEmpty()) return null;
        else{
            //Se busca el valor indicado por el usuario.
            BinaryTree<Association<K,V>> node = search(root,k);
            if(node != null){
                splay(node);
                return node.value().getValue();
            }
            return null;
        }
    }

    //Metodo recursivo que busca un valor en los nodos del arbol.
    private BinaryTree<Association<K,V>> search(BinaryTree<Association<K,V>> node, K k){
        //Pre: Se determina si el nodo donde se va a buscar el valor esta vacio. Si esta vacio se devuelve null.
        //Post: Se determina si se debe buscar en el nodo de derecha o izquierda.

        if(node == null) return null; //Condicion de recursion
        if(node.isEmpty()) return null; //Condicion de recursion
        if(k.equals(node.value().getKey())) return node;
        else if(k.compareTo(node.value().getKey()) < 0)
            return search(node.left(), k);
        else
            return search(node.right(), k);

    }

    //Metodo que permite agregar un valor al arbol.
    public V put(K k, V v){
        //Pre: Se determina si el arbol esta vacio. Si esta vacio se agrega el nodo a la raiz.
        //Post: Se busca en donde esta el arbol del cual sera hijo el nuevo nodo. Luego se determina si se ingresa a la derecha o izquierda.

        Association<K, V> temp = new Association<K,V>(k, v);
        BinaryTree<Association<K,V>> newNode = new BinaryTree<Association<K,V>>(temp);
        BinaryTree<Association<K,V>> tempTree = null;
        BinaryTree<Association<K,V>> tempRoot = root;
        if(root.isEmpty()){
            root = newNode;
            splay(root);
        }
        else {
            //Busqueda de padre donde se ingresara el nuevo valor.
            while (!tempRoot.isEmpty()){
                tempTree = tempRoot;
                if(temp.compareTo(tempRoot.value()) < 0)
                    tempRoot= tempRoot.left();
                else
                    tempRoot = tempRoot.right();
            }

            //Se pone el nodo encontrado como padre del nuevo nodo por ingresar.
            newNode.setParent(tempTree);

            //Se determina donde se ingresara el nuevo nodo.
            if(tempTree == null) root = newNode;
            else if(temp.compareTo(tempTree.value()) < 0)
                tempTree.setLeft(newNode);
            else
                tempTree.setRight(newNode);

            //Se lleva el nodo ingresado a la raiz del arbol.
            splay(newNode);
        }
        size++;
        return null;
    }

    //Metodo que permite hacer la operacion de splay para llevar el nodo operado mas reciente a la raiz.
    protected void splay(BinaryTree<Association<K,V>> tree){
        //Post: Se determina que tipo de movimiento debe hacer el nodo.

        while (tree.parent()!= null){
            //Operaciones de zig o zag
            if(tree.parent().parent() == null) {
                if(tree.parent().left().equals(tree)){
                    rotateRight(tree.parent());
                }
                else {
                    rotateLeft(tree.parent());
                }
            }
            else{
                //Operaciones de zig-zig, zig-zag, zag-zag, zag-zig
                if(tree.equals(tree.parent().left()) && tree.parent().equals(tree.parent().parent().left())){
                    rotateRight(tree.parent().parent());
                    rotateRight(tree.parent());
                }
                else if(tree.equals(tree.parent().right()) && tree.parent().equals(tree.parent().parent().right())){
                    rotateLeft(tree.parent().parent());
                    rotateLeft(tree.parent());
                }
                else if(tree.equals(tree.parent().left()) && tree.parent().equals(tree.parent().parent().right())){
                    rotateLeft(tree.parent());
                    rotateRight(tree.parent());
                }
                else {
                    rotateRight(tree.parent());
                    rotateLeft(tree.parent());
                }
            }
        }
        root = tree;
    }

    private void rotateRight(BinaryTree<Association<K,V>> node){
        //Post: Se hace una rotacion del padre de un nodo hacia la derecha. Zig
        BinaryTree<Association<K,V>> left = node.left();
        BinaryTree<Association<K,V>> tempRight = left.right();
        left.setRight(node);
        left.setParent(null);

        node.setLeft(new BinaryTree<Association<K,V>>());

        if(tempRight!=null){
            node.setLeft(tempRight);
        }
    }

    private void rotateLeft(BinaryTree<Association<K,V>> node){
        //Post: Se hace una rotacion del padre de un nodo hacia la derecha. Zag
        BinaryTree<Association<K,V>> right = node.right();
        BinaryTree<Association<K,V>> tempLeft = right.left();
        right.setLeft(node);
        right.setParent(null);

        node.setRight(new BinaryTree<Association<K,V>>());

        if(tempLeft != null){
            node.setRight(tempLeft);
        }
    }

    public boolean isEmpty(){
        return root == EMPTY;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }


}
