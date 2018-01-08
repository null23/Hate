import java.util.Stack;

/**
 * Created by mikaelw on 01/03/18.
 */
//单链表每K个节点逆序
public class P12 {
    public class Node{
        public int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public void reverseKNode(Node head, int k){
        int count = 1;
        Node cur = head;
        Node start = null;
        Node end = null;
        while(head != null){
            cur = cur.next;
            if(count == k){
                //若start为空(第一组为特殊组)，start指向头结点，head更新为这一组的最后一个节点
                if(start == null){
                    start = head;
                    head = cur;
                }
                reverseFromStartToEnd(start, end, head);
                count = 1;
            }
            count++;
        }
    }

    public void reverseFromStartToEnd(Node start, Node end, Node head){
        Node pre = null;
        Node next = null;
        if(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }
}
