package Chapter3;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by LENOVO on 2018/1/20.
 */
//二叉树按层遍历
public class P9 {
    public class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public void printByLevel(Node head){
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        int level = 1;
        Node last = head;
        //nLast是下一层的最右边节点
        Node nLast = null;
        queue.offer(head);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur);
            if(cur.left != null){
                queue.offer(cur.left);
                nLast = cur.left;
            }
            if(cur.right != null){
                queue.offer(cur.right);
                nLast = cur.right;
            }
            if(last == nLast && !queue.isEmpty()){
                System.out.println("level is:" + level++);
                last = nLast;
            }
        }
    }

    public void printByZigZag(Node head){
        if(head == null){
            return;
        }

    }
}
