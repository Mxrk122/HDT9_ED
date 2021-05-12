public class BinaryTree <E extends Comparable>{

    protected E value;
    protected BinaryTree<E> right, left;
    protected BinaryTree<E> parent;

    public BinaryTree(){
        value = null;
        parent = null;
        left = right = null;
    }

    public BinaryTree(E value){
        this.value = value;
        right = left = new BinaryTree<E>();
        setRight(right);
        setLeft(left);
    }

    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right){
        this.value = value;
        if(left == null) left = new BinaryTree<>();
        setRight(right);
        if(right == null) right = new BinaryTree<>();
        setLeft(left);
    }

    public BinaryTree<E> left(){
        return left;
    }

    public BinaryTree<E> right(){
        return right;
    }

    public BinaryTree<E> parent(){
        return parent;
    }

    public void setLeft(BinaryTree<E> newLeft){
        if(isEmpty()) return;
        if(left != null && left.parent()== this)
            left.setParent(null);
        left = newLeft;
        left.setParent(this);
    }

    public void setRight(BinaryTree<E> newRight){
        if(isEmpty()) return;
        if(right != null && right.parent()== this)
            left.setParent(null);
        right = newRight;
        right.setParent(this);
    }

    public void setParent(BinaryTree<E> parent){
        if(!isEmpty())
            this.parent = parent;
    }

    public E value(){
        return value;
    }

    public void setValue(E value){
        this.value = value;
    }

    public boolean isEmpty(){
        return value == null;
    }

}
