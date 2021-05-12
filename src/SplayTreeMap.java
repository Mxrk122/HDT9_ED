public class SplayTreeMap<K extends Comparable, V> {

    private BinaryTree<Association<K,V>> root;
    private BinaryTree<Association<K,V>> EMPTY;
    public SplayTreeMap(K k, V v){

    }

    public SplayTreeMap(){
        this(null, null);
    }

    public V get(K k){
        return null;
    }

    public V put(K k, V v){
        Association<K, V> temp = new Association<K,V>(k, v);
        BinaryTree<Association<K,V>> newNode = new BinaryTree<Association<K,V>>(temp,EMPTY, EMPTY);
        if(root.isEmpty()) root = newNode;
        else{
            BinaryTree<Association<K,V>> tempTree = null;
            BinaryTree<Association<K,V>> tempRoot = root;
            while (tempRoot!= null){
                tempTree = tempRoot;
                if(temp.compareTo(tempTree.value()) < 0)
                    tempTree = tempTree.left();
                else
                    tempTree = tempTree.right();
            }

            newNode.setParent(tempTree);
            if(tempTree == null) root = newNode;
            else if(temp.compareTo(tempTree.value()) < 0)
                tempTree.setLeft(newNode);
            else
                tempTree.setRight(newNode);

            splay(newNode);
        }

        return null;
    }

    protected void splay(BinaryTree<Association<K,V>> tree){
        while (tree.parent()!= null){
            if(tree.parent().parent() == null) {
                if(tree.parent().left().equals(tree)){
                    rotateRight(tree.parent());
                }
                else {
                    rotateLeft(tree.parent);
                }
            }
            else{
                if(tree == tree.parent().left() && tree.parent() == tree.parent().parent().left()){
                    rotateRight(tree.parent().parent());
                    rotateRight(tree.parent());
                }
                else if(tree == tree.parent().right() && tree.parent() == tree.parent().parent().right()){
                    rotateLeft(tree.parent().parent());
                    rotateLeft(tree.parent());
                }
                else if(tree == tree.parent().left() && tree.parent() == tree.parent().parent().right()){
                    rotateLeft(tree.parent().parent());
                    rotateRight(tree.parent());
                }
                else {
                    rotateRight(tree.parent().parent());
                    rotateLeft(tree.parent());
                }
            }
        }
    }

    private void rotateRight(BinaryTree<Association<K,V>> node){
        BinaryTree<Association<K,V>> parent = node.parent();
        BinaryTree<Association<K,V>> tempRight = node.right();

        node.setRight(parent);
        node.setParent(null);

        if(tempRight != null){
            parent.setLeft(tempRight);
        }
    }

    private void rotateLeft(BinaryTree<Association<K,V>> node){
        BinaryTree<Association<K,V>> parent = node.parent();
        BinaryTree<Association<K,V>> tempLeft = node.left();

        node.setLeft(parent);
        node.setParent(null);

        if(tempLeft != null){
            parent.setLeft(tempLeft);
        }
    }

    private boolean isEmpty(){
        return root == EMPTY;
    }

}
