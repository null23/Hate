package Chapter2;

/**
 * Created by mikaelw on 12/26/17.
 */
public class P6  {
    public class Node{
        public int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }
    //默认是环形链表
    public void josephusKill1(Node head, int m){
        int count = 0;
        Node last = head;
        //遍历last为node前一个元素
        while(last.next != head){
            last = last.next;
        }

        //head紧随last同步向前移动
        while(head != last){
            if(++count == m){
                //删除
                last.next = head.next;
                count = 0;
            }else{
                last = last.next;
            }
            head = last.next;
        }
    }


    //我一开认为不是环形链表，因为删除需要两个节点，所以我想着纪录到第二次，就直接利用之前的节点配合第三次之后的节点删除
    //但是只利用head一个节点的话，就很难判断如果只剩下两个节点再不能形成环时该怎么做了
    public void josephusKill2(Node head, int m){
        Node last = head;
        //形成环形链表
        while(last.next != null){
            last = last.next;
        }
        last.next = head;

        Node cur = head;

        int res = 0;
        while(head != last){
            if(++res == m){

            }
        }
    }
}
