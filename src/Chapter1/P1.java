import java.util.Stack;

/**
 * Created by mikaelw on 12/13/17.
 */
public class P1 {
    private Stack<Integer> stackData;
    private Stack<Integer> statckMin;

    public P1(){
        this.stackData = new Stack<Integer>();
        this.statckMin = new Stack<>();
    }

    //插入
    public void push(int data){
        if(this.stackData.isEmpty()){
            this.statckMin.push(data);
            //peek()查看栈顶元素,pop()移除栈顶元素
        }else if(data <= this.stackData.peek()){
            this.statckMin.push(data);
        }
        this.stackData.push(data);
    }

    //删除栈顶元素
    public void pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Stack Is Empty");
        }
    }

    //查询最小元素
    public int getMin(){
        if(this.statckMin.isEmpty()){
            throw new RuntimeException("Stack Is Empty");
        }
        int min = this.statckMin.peek();
        return 0;
    }

}
