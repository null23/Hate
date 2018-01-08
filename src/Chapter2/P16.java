package Chapter2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mikaelw on 01/03/18.
 */
public class P16 {
    public class Node {
        public int data;
        private Node left;
        private Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public Node reverse1(Node head){
        Queue queue = new LinkedList();
        inOrderToQueue1(head, queue);
        if(queue.isEmpty()){
            return head;
        }
        return head;
    }

    public void inOrderToQueue1(Node head, Queue queue){
        if(head == null){
            return;
        }
        inOrderToQueue1(head.left, queue);
        queue.offer(head);
        inOrderToQueue1(head.right, queue);
    }
}
