package Chapter1;

import java.util.Stack;

/**
 * Created by mikaelw on 12/14/17.
 */
public class P5 {
    //从栈顶到栈底从大到小排序数字
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            //辅助栈不为空，并且本栈栈顶元素小于当前辅助栈栈顶元素
            while(!help.isEmpty() && cur > help.peek()){
                //把辅助站中的所有元素依次放回本栈中，重新排序，保证cur是当前最小的
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
