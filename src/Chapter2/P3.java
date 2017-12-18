package Chapter2;

/**
 * Created by mikaelw on 12/18/17.
 */
public class P3 {
    public class Node{
        public int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public Node removeMidNode(Node head, int a, int b){
        int n = 0;
        Node cur = head;
        while(cur != null){
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil(((double) (a * n)) / ((double) (b)));
        if(n == 0){
            return head;
        }
        if(n > 1){
            cur = head;
            //把cur控制在要删除之前的前一个元素
            while(--n != 1){
                n--;
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
