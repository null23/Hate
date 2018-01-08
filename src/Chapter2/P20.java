/**
 * Created by LENOVO on 2018/1/8.
 */
public class P20 {
    public class Node {
        public int data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    //把链表分为左右两个部分
    public void relocate(Node head){
        Node mid = head;
        Node right = head.next;

        //right走两个，mid走一个，mid正好是中间位置
        while(right.next != null && right.next.next != null){
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        merge(head, right);
    }

    public void merge(Node left, Node right){
        if (left == null){
            return;
        }
        Node next = null;
        while(left != null){
            next = left.next;
            left.next = right;
            right = right.next;
            left.next.next = next;
            left = next;
        }
        left.next = right;
    }

}
