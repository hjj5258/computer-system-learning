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

    public boolean contains(E e) {
        // 简单判断 应该用工具类
        if (Objects.isNull(e)) {
            return false;
        }

        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else // (e.compareTo(node.e) > 0)
        {
            return contains(node.right, e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println("Node e value is " + node.e);

        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTStr(root, 0, res);
        return res.toString();
    }

    private void generateBSTStr(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthStr(depth) + "null \n");
            return;
        }
        res.append(generateDepthStr(depth) + node.e + "\n");
        generateBSTStr(node.left, depth + 1, res);
        generateBSTStr(node.right, depth + 1, res);
    }

    private String generateDepthStr(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
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
        System.out.println("Test contains method");
        System.out.println(searchTree.contains(11));
        System.out.println(searchTree.contains(22));
        System.out.println(searchTree.contains(9));
        System.out.println(searchTree.contains(7));
        System.out.println(searchTree.contains(null));
//        searchTree.preOrder();
        System.out.println(searchTree);
    }
}
