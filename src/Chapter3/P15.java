package Chapter3;
import java.util.Stack;

/**
 * Created by mikaelw on 01/25/18.
 */
//判断一棵树是否非平衡二叉树
public class P15 {
    public class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public boolean isBST(Node head){
        if(head == null){
            return false;
        }
        Node cur = head;
        Stack<Node> stack = new Stack<Node>();
        Node pre = null;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(pre != null && pre.data > cur.data){
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }
}
