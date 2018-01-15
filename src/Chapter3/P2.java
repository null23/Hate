package Chapter3;
/**
 * Created by mikaelw on 01/09/18.
 */
public class P2 {
    public class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public void printEdge1(Node head){
        if(head == null){
            return;
        }
        //获得二叉树高度
        int height = getHeight(head, 0);
        //根据二叉树高度建立存储边缘节点的数组
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head, height, edgeMap);
        //打印所有左半区的最左结点
        for(int i = 0; i != edgeMap.length; i++){
            System.out.println(edgeMap[i][0]);
        }
        //打印既不是最左又不是最右的叶子结点
        printLeafNotInMap(head, 0, edgeMap);
        //逆时针打印所有右半区的最右结点
        for(int i = edgeMap.length - 1; i > 0; i--){
            if(edgeMap[i][0] != edgeMap[i][1]){
                System.out.println(edgeMap[i][1]);
            }
        }
    }

    public int getHeight(Node h, int l){
        if(h == null){
            return l;
        }
        return Math.max(getHeight(h.left, l + 1), getHeight(h.right, l + 1));
    }

    public void setEdgeMap(Node h, int l, Node[][] edgeMap){
        if(h == null){
            return;
        }
        //记录最左边缘节点
        edgeMap[l][0] = edgeMap[l][0] == null ? h : edgeMap[l][0];
        //记录右边缘节点，但是要记住，是逆时针打印
        edgeMap[l][1] = h;
        //先打印左侧节点，再打印右侧节点，让左侧节点先覆盖数组
        setEdgeMap(h.left, l + 1, edgeMap);
        setEdgeMap(h.right, l + 1, edgeMap);
    }

    public void printLeafNotInMap(Node h, int l, Node[][] m){
        if(h == null){
            return;
        }
        if(h.left == null && h.right == null && h != m[l][0] && h != m[l][1]){
            System.out.println(h.data);
        }
        printLeafNotInMap(h.left, l + 1, m);
        printLeafNotInMap(h.right, l + 1, m);
    }
}
