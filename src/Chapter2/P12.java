import java.util.Stack;

/**
 * Created by mikaelw on 01/03/18.
 */
//单链表每K个节点逆序
public class P12 {
    public class Node {
        public int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node reverseKNodes1(Node head, int k){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        Node pre = null;
        int count = 1;
        while(cur != null){
            stack.push(cur);
            if(count == k){
                //pre是某一组的开头
//                if(pre == null){
//                    pre = head;
//                }
                pre = resign(stack, cur, pre);
            }
            cur = cur.next;
            count++;
        }

        return head;
    }

    public Node resign(Stack<Node> stack, Node left, Node right){
        Node p = null;
        //每次弹出来的元素称为cur
        Node cur = stack.pop();
        //如果left为空，也就是没逆序前，这一组的开头的元素为空，说明这是第一组，第一组是特殊的
        if(left != null){
            //直接让逆序后的最后一个节点指向
            left.next = cur;
        }
        Node next = null;
        //依次弹出栈中节点
        while(!stack.isEmpty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }
}
