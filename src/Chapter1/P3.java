import java.util.Stack;

/**
 * Created by mikaelw on 12/14/17.
 */
public class P3 {

    //移除栈底元素，并且返回
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    //递归的方式——调用getAndRemoveLastElement()，依次移除栈底元素，然后递归调用本函数(目的是造成逆序)，最后把被移除的栈底元素放入栈顶
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int deletedLastElement = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(deletedLastElement);
    }
}
