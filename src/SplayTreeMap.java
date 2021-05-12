public class SplayTreeMap<K extends Comparable, V> {

    private BinaryTree<Association<K,V>> root;
    private BinaryTree<Association<K,V>> EMPTY = new BinaryTree<Association<K,V>>();
    public SplayTreeMap(K k, V v){
        Association<K,V> association = new Association<K,V>(k, v);
        root = new BinaryTree<Association<K,V>>(association);
    }

    public SplayTreeMap(){
        root = EMPTY;
    }

    public V get(K k){
        if(root.isEmpty()) return null;
        else{
            //System.out.println(root.left().left().parent().value().getValue());
            BinaryTree<Association<K,V>> node = search(root,k);
            //System.out.println(node.parent().value().getValue());
            splay(node);
            return node.value().getValue();
        }
    }

    private BinaryTree<Association<K,V>> search(BinaryTree<Association<K,V>> node, K k){

        if(k.equals(node.value().getKey())) return node;
        else if(k.compareTo(node.value().getKey()) < 0)
            return search(node.left(), k);
        else
            return search(node.right(), k);

    }

    public V put(K k, V v){
        Association<K, V> temp = new Association<K,V>(k, v);
        //System.out.println(k);
        BinaryTree<Association<K,V>> newNode = new BinaryTree<Association<K,V>>(temp);
        BinaryTree<Association<K,V>> tempTree = null;
        BinaryTree<Association<K,V>> tempRoot = root;
        if(root.isEmpty()) root = newNode;
        else {
            int i = 0;
            while (!tempRoot.isEmpty()){
                i++;
                tempTree = tempRoot;
                if(temp.compareTo(tempRoot.value()) < 0)
                    tempRoot= tempRoot.left();
                else
                    tempRoot = tempRoot.right();
            }
            //System.out.println(tempTree.value().getValue());
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
        //System.out.println(tree.value().getValue());
        while (tree.parent()!= null){
            if(tree.parent().parent() == null) {
                if(tree.parent().left().equals(tree)){
                    rotateRight(tree.parent());
                }
                else {
                    rotateLeft(tree.parent());
                }
            }
            else{
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
        BinaryTree<Association<K,V>> right = node.right();
        BinaryTree<Association<K,V>> tempLeft = right.left();
        right.setLeft(node);
        right.setParent(null);

        node.setRight(new BinaryTree<Association<K,V>>());

        if(tempLeft != null){
            node.setRight(tempLeft);
        }
    }

    private boolean isEmpty(){
        return root == EMPTY;
    }

}
