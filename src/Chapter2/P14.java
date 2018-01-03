package Chapter2;

/**
 * Created by mikaelw on 01/03/18.
 */
public class P14 {
    public class Node {
        public int data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public Node removeValue(Node head, int res){
        Node pre = head;
        Node cur = head.next;

        while(cur != null){
            //若头结点的值与目标值相等
            if(pre.data == res){
                head = cur;
                pre = head;
                cur = pre.next;
            }
            //后节点与目标值相等，直接删除
            if(cur.data == res){
                pre.next = cur.next;
            }else{
                pre = cur;
            }

            cur = cur.next;
        }

        return head;
    }
}
