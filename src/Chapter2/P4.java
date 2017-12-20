package Chapter2;

/**
 * Created by mikaelw on 12/19/17.
 */
public class P4 {
    public class Node{
        public int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        if(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public class DoubleNode{
        public int data;
        private DoubleNode last;
        private DoubleNode next;
        public DoubleNode(int data){
            this.data = data;
        }
    }

    public DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        if(head != null){
            next = head.next;
            head.last = next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
