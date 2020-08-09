import org.junit.Assert;
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

        Assert.assertEquals(array.contains(10),true);
        Assert.assertEquals(array.contains(11),false);

        array.remove(2);
        System.out.println(array);

        array.removeFirst();
        System.out.println("removeFirst");
        System.out.println(array);

        array.removeLast();
        System.out.println("removeLast");
        System.out.println(array);

        int element = 2;
        array.removeElement(element);
        System.out.println("removeElement");
        System.out.println(array);
    }

}
