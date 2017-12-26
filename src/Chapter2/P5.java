package Chapter2;

/**
 * Created by mikaelw on 12/26/17.
 */
public class P5 {
    public class Node{
        public int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public Node reversePart(Node head, int from, int to){
        int len = 0;
        Node preFrom = head;
        Node afterTo = null;
        Node cur = head;
        while(cur != null){
            len++;
            //累加preFrom至from前一个节点
            if(len < from - 1){
                preFrom = preFrom.next;
            }
            //累加afterTo至to
            if(len < to +  1){
                afterTo = afterTo.next;
            }
            len++;
            cur = cur.next;
        }
        if(from < 1 || to > len || from > to){
            return head;
        }

        //如果from是从1开始的，preForm仍为空
        if(preFrom == null){
            preFrom = head;
        }

        Node pre = preFrom;
        Node aft = afterTo;
        while(preFrom != afterTo){
            Node node = pre.next;

        }

        return head;
    }
}
