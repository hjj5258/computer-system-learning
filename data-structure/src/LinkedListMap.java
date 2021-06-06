import java.util.ArrayList;

/**
 * @author hjj
 * @create 2021/06/06/13:40
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V val;
        public Node next;

        public Node() {
            this(null, null, null);
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node(K key, V val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        this.dummyHead = new Node();
        size = 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key))
                return cur;

            cur = cur.next;
        }

        return null;
    }

    @Override
    public void add(K key, V val) {
        Node node = getNode(key);
        if (node == null) {
            // 生成一个node node的next 指向原先dummyHead next，然后在将dummyHead next指向这个新的node
            dummyHead.next = new Node(key, val, dummyHead.next);
            size++;
        } else {
            // 存在相同key，则更新值
            node.val = val;
        }
    }

    @Override
    public V remove(K key) {
        Node node = getNode(key);
        if (node != null) {
            Node prev = dummyHead;
            while (prev != null) {
                if (prev.next.key.equals(key)) {
                    break;
                }
                prev = prev.next;
            }

            if (prev != null) {
                Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
                size--;
                return delNode.val;
            }
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.val;
    }

    @Override
    public void set(K key, V newVal) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
        node.val = newVal;
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
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("data-structure/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
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
