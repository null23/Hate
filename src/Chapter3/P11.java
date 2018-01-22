package Chapter3;
/**
 * Created by LENOVO on 2018/1/21.
 */
public class P11 {
    public class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public boolean contain(Node t1, Node t2){
        return check(t1, t2) || contain(t1.left,t2) ||contain(t1.right,t2);
    }

    public boolean check(Node h, Node t2){
        if(t2 == null){
            return true;
        }
        if(h == null || h.data != t2.data){
            return false;
        }
        return check(h.left, t2.left) && check(h.right, t2.right);
    }
}
