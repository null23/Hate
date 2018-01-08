package Chapter2;

import java.util.HashSet;

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

    public void removeRep1(Node head){
        if(head == null){
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(head.data);
        Node pre = head;
        Node cur = head.next;
        while(cur != null){
            if(hashSet.contains(cur.data)){
                //删除此节点
                pre.next = cur.next;
            }else{
                hashSet.add(cur.data);
                pre = cur;
            }
            cur = cur.next;
        }
    }
}
