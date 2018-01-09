package Chapter3;

import java.util.Stack;

/**
 * Created by mikaelw on 01/09/18.
 */
public class P1 {
    public class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data){
            this.data = data;
        }
    }

    //递归
    //前序遍历
    public void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.data);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //中序遍历
    public void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.data);
        inOrderRecur(head.right);
    }

    //后序遍历
    public void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.data);
    }

    //非递归
    //前序遍历
    public void preOrderUnRecur(Node head){
        if(head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);

        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.data);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    //中序遍历
    public void inOrderUnRecur(Node head){
        if(head == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(!stack.isEmpty() || cur != null){
            //先把cur下的所有边缘左节点入栈
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

    //后序遍历
    public void postOrderUnRecur(Node head){

    }
}
