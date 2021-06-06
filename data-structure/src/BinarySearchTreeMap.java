import java.util.ArrayList;

public class BinarySearchTreeMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V val;
        public Node left;
        public Node right;

        public Node() {
            this(null, null, null, null);
        }

        public Node(K key) {
            this(key, null, null, null);
        }

        public Node(K key, V val) {
            this(key, val, null, null);
        }

        public Node(K key, V val, Node left, Node right) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(K key, V val) {
        root = add(key, val, root);
    }

    private Node add(K key, V val, Node node) {
        if (node == null) {
            size++;
            return new Node(key, val);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(key, val, node.left);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(key, val, node.right);
        } else {
            node.val = val;
        }

        return node;
    }

    private Node minmum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minmum(node.left);
    }

    @Override
    public V remove(K key) {
        Node node = getNode(key, root);
        if (node != null) {
            root = remove(key, root);
            return node.val;
        }
        return null;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node);
        return node;
    }


    private Node remove(K key, Node node) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(key, node.left);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(key, node.right);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successors = minmum(node.right);
            successors.right = removeMin(node.right);
            successors.left = node.left;

            node.left = node.right = null;
            return successors;
        }
    }


    private Node getNode(K key, Node node) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(key, node.left);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(key, node.right);
        } else {
            return node;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(key, root) != null;
    }

    @Override
    public V get(K key) {
        Node rst = getNode(key, root);
        return rst == null ? null : rst.val;
    }

    @Override
    public void set(K key, V newVal) {
        Node rst = getNode(key, root);
        if (rst == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }

        rst.val = newVal;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {

//        BinarySearchTreeMap<String, Integer> map = new BinarySearchTreeMap<>();
//        map.add("a", 1);
//        map.add("b", 1);
//        map.add("c", 1);
//        map.add("d", 1);
//
//        map.remove("a");
//        System.out.println(map);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("data-structure/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BinarySearchTreeMap<String, Integer> map = new BinarySearchTreeMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
        }

    }
}
