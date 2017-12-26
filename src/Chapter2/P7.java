import java.util.Stack;

/**
 * Created by LENOVO on 2017/12/26.
 */
public class P7 {
    public class Node{
        public int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }
    //head!=null和head.next!=null的区别
    public boolean isPalindrome(Node head){
        Stack<Integer> stack = new Stack<>();
        Node cur = head;
        while(cur != null){
            stack.push(head.data);
            cur = cur.next;
        }
        cur = head;
        while (!stack.isEmpty()){
            if(stack.pop() != cur.data){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public boolean isPalindrome2(Node head){
        Node cur = head;
        Node right = cur.next.next;
        //直接把链表折叠，这样节省栈的空间，比较次数也会减少
        //每次right移动一格，cur移动两格，达到折叠的目的
        while(cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Integer> stack = new Stack<>();
        while(right != null){
            stack.push(head.data);
            right = right.next;
        }
        cur = head;
        while (!stack.isEmpty()){
            if(stack.pop() != cur.data){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}
