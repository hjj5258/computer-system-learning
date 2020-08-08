import org.junit.Test;

public class ArrayTest {
    @Test
    public void basicsTest() {
        Array array = new Array();
        for (int i = 0; i < 8; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(2, 10);
        System.out.println(array);
    }

}
