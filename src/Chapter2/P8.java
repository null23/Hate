package Chapter2;

/**
 * Created by mikaelw on 12/27/17.
 */
public class P8 {
    public class Node {
        public int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node listPartition1(Node head, int pivot) {
        Node cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int arr[] = new int[len];
        cur = head;
        for (int i = 0; i < len; i++) {
            arr[i] = cur.data;
            cur = cur.next;
        }

        //对数组进行排序


        return head;
    }

    public Node listPartition2(Node head, int pivot) {
        //分出三个链表,比pivot小的，等于的，大的，然后把三个链表拼接起来即可
        Node small = null;
        Node smallHead = null;
        Node equal = null;
        Node equalHead = null;
        Node big = null;
        Node bigHead = null;

        Node cur = head;
        while(cur != null){
            if(cur.data < pivot){
                if(small == null){
                    small = cur;
                    smallHead = cur;
                }else{
                    small.next = cur;
                    small = cur;
                }
            }else if(cur.data == pivot){
                if(equal == null){
                    equal = cur;
                    equalHead = cur;
                }else{
                    equal.next = cur;
                    equal = cur;
                }
            }else if(cur.data > pivot){
                if(big == null){
                    big = cur;
                    bigHead = cur;
                }else{
                    big.next = cur;
                    big = cur;
                }
            }
            cur = cur.next;
        }

        small.next = equalHead;
        equal.next = bigHead;
        return smallHead;
    }
}