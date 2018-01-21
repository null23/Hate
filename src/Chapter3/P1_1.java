import java.util.Stack;

/**
 * Created by LENOVO on 2018/1/21.
 */
public class P1_1 {
    public class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int data){
            this.data = data;
        }
    }

    //中序遍历非递归
    public void inOrderUnRecur(Node head){
        if(head == null){
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while(!stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                System.out.println(cur.data);
                cur = cur.right;
            }
        }
    }
}
