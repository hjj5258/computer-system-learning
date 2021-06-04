import java.util.ArrayList;

public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> bst;

    public BinarySearchTreeSet() {
        bst = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");
        long startTime = System.currentTimeMillis();

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("data-structure/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BinarySearchTreeSet<String> set1 = new BinarySearchTreeSet<>();
            for (String word : words1) {
                set1.add(word);
            }
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("data-structure/a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            BinarySearchTreeSet<String> set2 = new BinarySearchTreeSet<>();
            for (String word : words2) {
                set2.add(word);
            }
            System.out.println("Total different words: " + set2.getSize());
        }

        long endTime = System.currentTimeMillis();

        System.out.println((endTime - startTime) / 1000 + "s");
    }
}
