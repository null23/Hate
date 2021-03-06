package Chapter3;
import java.util.Stack;

/**
 * Created by LENOVO on 2018/1/21.
 */
public class P10 {
    public class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public Node[] getToErrNodes(Node head){
        Node[] errs = new Node[2];

        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        Node pre = null;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(pre != null && pre.data > cur.data){
                    errs[0] = errs[0] == null ? pre : errs[0];
                    errs[1] = cur;
                }
                pre = head;
                cur = cur.right;
            }
        }
        return errs;
    }
}
