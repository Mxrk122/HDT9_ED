public class FactoryTrees<K extends Comparable, V extends Comparable>{
    private Map TreeMap;

    public Map createTree(int option){
        if(option==1){
            TreeMap = new HashTree<K, V>();
        }
        else {
            TreeMap = new SplayTreeMap<K, V>();
        }

        return TreeMap;
    }
}

