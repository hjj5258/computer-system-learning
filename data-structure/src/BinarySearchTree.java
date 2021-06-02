import java.util.Objects;

/**
 * @author hjj
 * @create 2021/06/02/21:10
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
//        if (this.root == null) {
//            this.root = new Node(e);
//            return;
//        }
        // 简单判断 应该用工具类
        if (Objects.isNull(e)) {
            return;
        }
        root = add(root, e);
    }

    private Node add(Node node, E e) {
//        if (node.e.compareTo(e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        }
//
//        if (node.e.compareTo(e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (node.e.compareTo(e) < 0) {
//            add(node.left, e);
//        } else add(node.right, e);

        // 如果没有节点则会新建root，或者有节点则递归到为空为止新建node
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            // 拼接left
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            // 拼接right
            node.right = add(node.right, e);
        }
        return node;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();
//        searchTree.add(1);
//        searchTree.add(2);
//        searchTree.add(3);
//        searchTree.add(4);
//        searchTree.add(5);

        searchTree.add(11);
        searchTree.add(22);
        searchTree.add(9);
        searchTree.add(7);
        searchTree.add(null);
        System.out.println(searchTree);
    }
}
