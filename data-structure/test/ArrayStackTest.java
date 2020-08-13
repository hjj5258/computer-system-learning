import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

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


    /**
     * 符号匹配问题
     * https://leetcode-cn.com/problems/valid-parentheses/
     */
    @Test
    public void validParentheses() {
        String s1 = "()";
        String s2 = "[]";
        String s3 = "{}";

        Assert.assertEquals(isValid(s1), true);
        Assert.assertEquals(isValid(s2), true);
        Assert.assertEquals(isValid(s3), true);

        String q1 = "{]{()";
        String q2 = "([)]";
        String q3 = "{{()}}";

        Assert.assertEquals(isValid(q1), false);
        Assert.assertEquals(isValid(q2), false);
        Assert.assertEquals(isValid(q3), true);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
