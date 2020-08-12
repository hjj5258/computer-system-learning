import org.junit.Assert;
import org.junit.Test;

public class ArrayStackTest {

    @Test
    public void basicsTest() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
        }

        System.out.println(arrayStack);
        Integer pop = arrayStack.pop();
        System.out.println("pop:" + pop);
        System.out.println(arrayStack);

        System.out.println("peek:" + arrayStack.peek());
        Assert.assertEquals(arrayStack.isEmpty(), false);
    }
}
