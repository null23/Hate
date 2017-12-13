import java.util.Stack;

/**
 * Created by LENOVO on 2017/12/14.
 */
public class P2 {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public P2(){
        stackPop = new Stack<Integer>();
        stackPush = new Stack<Integer>();
    }

    public void add(int data){
        stackPush.push(data);
    }

    public int poll(int data){
        //两个栈都是空的，肯定报错
        if(stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("Queue Is Empty");
            //倒序栈是空的，入栈是非空的，一次性把入栈的东西放进倒序栈里
        }else if(stackPop.empty()){
            //入栈非空的，才能倒序放数据
            while (!stackPush.empty()){
                stackPop.push(data);
            }
        }
        return stackPop.pop();
    }

    public int peek(){
        if(stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("Queue Is Empty");
            //倒序栈是空的，入栈是非空的，一次性把入栈的东西放进倒序栈里
        }else if(stackPop.empty()){
            //入栈非空的，才能倒序放数据
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}

