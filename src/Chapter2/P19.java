
/**
 * Created by mikaelw on 01/04/18.
 */
public class P19 {
    public class Node {
        public int data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public Node merge(Node head1, Node head2){
        if(head1 == null && head2 == null){
            return head1 == null ? head2 : head1;
        }
        //head是小的那个
        Node head = head1.data < head2.data ? head1 : head2;
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head2 ? head2 : head1;

        Node pre = null;
        //把cur2比cur1虽有元素小的，全部放进来
        while(cur1 != null && cur2 != null){
            if(cur1.data <= cur2.data){
                pre = cur1;
                cur1 = cur1.next;
            }else if(cur1.data > cur2.data){
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = cur2.next;
            }
        }

        //cur2可能会有比最大元素还要大的，所以把cur2中剩下的大的全部放在cur1后边
        //如果cur1不为空，那说明承cur2全部都在cur1中了，所以把cur1剩下的连接上就行了
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
