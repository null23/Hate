package Chapter2;

/**
 * Created by mikaelw on 01/04/18.
 */
public class P18 {
    public class Node {
        public int data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public Node insertNum(Node head, int num){
        Node node = new Node(num);
        if(head == null){
            head = node;
        }
        Node pre = head;
        Node cur = head.next;
        while(cur != head){
            if(num > pre.data && num < cur.data){
                pre.next = node;
                node.next = cur;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }

        //此时pre就是环尾节点
        //若num比头结点的值还小
        if(num < head.data){
            node.next = head;
            head = node;
            pre.next = head;
        }
        //若num的值比尾节点的值还大
        if(num > pre.data){
            pre.next = node;
            node.next = head;
        }
        return head;
    }
}
