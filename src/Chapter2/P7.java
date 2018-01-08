package Chapter2;

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

    //不需要其他多余的数据结构
    public boolean isPalindrome3(Node head){
        //左半区
        Node n1 = head;
        //右半区(需要逆序)
        Node n2 = head;
        while(n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        //n2从倒数第一个/倒数第二个的位置变为右半区开头
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        //翻转链表
        while(n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        //保存最后一个节点，现在n1是最后一个节点
        n3 = n1;
        //左边第一个节点，现在n2是头结点
        n2 = head;

        //比较回文结构
        while(n2 != null && n2 != null){
            if(n1.next != n2.next){
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        n1 = n3.next;
        n3.next = null;

        while(n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return true;
    }
}
