package Chapter2;

/**
 * Created by mikaelw on 12/18/17.
 */
public class P1 {
    public class Node{
        public int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public static void getCommonPart(Node head1, Node head2){
        while(head1 != null && head2 != null){
            //head1和head2均为有序链表
            if(head1.data > head2.data){
                head2 = head2.next;
            }else if(head1.data < head2.data){
                head1 = head1.next;
            }else{
                System.out.println(head1.data);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
