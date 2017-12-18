package Chapter2;

/**
 * Created by mikaelw on 12/18/17.
 */
public class P2 {
    public class Node{
        public int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static Node removeLastKthNode(Node head, int k){
        if(k < 1){
            return head;
        }
        Node p = head;
        while(head != null){
            head = head.next;
            k--;
        }
        head = p;
        if(k == 0){
            return head;
        }
        if(k < 0){
            while(k <= 0){
                k = k + 1;
                head = head.next;
            }
            if(k == 0){
                p = head.next;
                head.next = head.next.next;
            }
        }
        return head;
    }
}
