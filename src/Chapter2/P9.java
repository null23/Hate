
import java.util.HashMap;

/**
 * Created by mikaelw on 12/28/17.
 */
public class P9 {
    public class Node {
        public int data;
        private Node next;
        private Node rand;

        public Node(int data) {
            this.data = data;
        }
    }

    //通过哈希表
    public Node copyListWithRand1(Node head) {
        Node cur = head;
        HashMap<Node, Node> hashMap = new HashMap<>();
        while (cur != null) {
            //把新的节点依次放入hashmap
            hashMap.put(cur, new Node(cur.data));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            hashMap.get(cur).next = hashMap.get(cur.next);
            hashMap.get(cur).rand = hashMap.get(cur.rand);
            cur = cur.next;
        }
        return hashMap.get(head);
    }

    public Node copyListWithRand2(Node head) {
        Node cur = head;
        //复制每个节点
        while(cur != null){
            Node after = cur.next;
            Node copy = new Node(cur.data);
            cur.next = copy;
            copy.next = after;
//            不能在这里直接设置copy的rand节点，因为节点尚未补充完毕
//            copy.rand = cur.rand;
        }

        cur = head;
        //复制出的节点的rand和其前一个节点的rand是相同的
        while(cur != null){
            Node copy = cur.next;
            copy.rand = cur.rand.next;
            cur = cur.next.next;
        }

        cur = head;
        Node copyHead = null;
        //脱离复制出的节点
        while(cur != null){
            Node after = cur.next.next;
            if(copyHead == null){
                copyHead = cur.next;
            }else{
                copyHead.next = after.next;
            }

            cur.next = after;
            cur = after;
        }
        return head;
    }
}