import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.*;

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

    /**
     * 非递归实现前序遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println("Node e value is " + cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println("Node e value is " + node.e);

        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        preOrder(node.left);
        System.out.println("Node e value is " + node.e);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println("Node e value is " + node.e);
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // 查看队头
            Node cur = queue.remove();
            System.out.println("Node e value is " + cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public Node maxmum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maxmum(root);
    }

    private Node maxmum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxmum(node.right);
    }

    public Node minmum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minmum(root);
    }

    private Node minmum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minmum(node.left);
    }

    public E removeMin() {
        E ret = minmum().e;
        // 删除完之后的root 重新指向 当前root
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        // 最后一次递归的上一层
        node.left = removeMin(node.left);

        // 最开始的node
        return node;
    }


    public E removeMax() {
        E ret = maxmum().e;
        // 删除完之后的root 重新指向 当前root
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        // 最后一次递归的上一层
        node.right = removeMax(node.right);

        // 最开始的node
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            // 递归完成后当前的node.left = resultNode
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            // 递归完成后当前的node.right = resultNode
            node.right = remove(node.right, e);
            return node;
        } else { // e.compareTo(node.e) == 0
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
            // 左右孩子都不为空的情况
            // 找到比待删除节点大的最小节点，待删除节点右子树的最小节点
            // 用这个节点顶替带删除节点的位置 Hibbard Deletion 方法
            Node successors = minmum(node.right);
            successors.right = removeMin(node.right);
            successors.left = node.left;

            node.left = node.right = null;
            return successors;
        }
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
        searchTree.add(8);
        searchTree.add(null);


//        System.out.println(searchTree);

//        System.out.println("Test contains method");
//        System.out.println(searchTree.contains(11));
//        System.out.println(searchTree.contains(22));
//        System.out.println(searchTree.contains(9));
//        System.out.println(searchTree.contains(7));
//        System.out.println(searchTree.contains(null));

//        System.out.println("Test preOrder method");
//        searchTree.preOrder();
//        System.out.println("Test inOrder method");
//        System.out.println("中序遍历就会把二分搜索树进行排序");
//        searchTree.inOrder();
//        System.out.println("Test postOrder method");
//        System.out.println("中序遍历就会把二分搜索树进行排序");
//        searchTree.postOrder();

//        System.out.println("Test preOrder method");
//        searchTree.preOrder();
//
//        System.out.println("Test preOrderNR method");
//        searchTree.preOrderNR();

//        System.out.println("Test levelOrder method");
//        searchTree.levelOrder();
//        System.out.println("Test before removeMin method");
//        System.out.println(searchTree);
//        System.out.println("Test removeMin method");
//        System.out.println("Result value is " + searchTree.removeMin());
//        System.out.println(searchTree);

//        System.out.println("Test before removeMax method");
//        System.out.println(searchTree);
//        System.out.println("Test removeMax method");
//        System.out.println("Result value is " + searchTree.removeMax());
//        System.out.println(searchTree);

//        System.out.println("Test before remove method");
//        System.out.println(searchTree);
//        System.out.println("Test remove method");
//        searchTree.remove(11);
//        System.out.println(searchTree);

    }
}
