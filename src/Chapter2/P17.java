package Chapter2;

/**
 * Created by mikaelw on 01/04/18.
 */
public class P17 {
    public class Node {
        public int data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    public void removeNodeWired(Node node){
        if(node == null){
            return;
        }

        Node next = node.next;
        if(next == null){
            return;
        }
        node.data = next.data;
        node.next = next.next;
    }
}
