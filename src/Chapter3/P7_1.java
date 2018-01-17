package Chapter3;
/**
 * Created by mikaelw on 01/17/18.
 */
//https://www.cnblogs.com/ygj0930/p/6618915.html
public class P7_1 {
    public class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public Node getMax(Node head){
        int record[] = new int[3];
        return postOrder(head, record);
    }

    public Node postOrder(Node head, int[] record){
        if(head == null){
            //左子树的最大值
            record[0] = Integer.MIN_VALUE;
            //右子树的最小值
            record[1] = Integer.MAX_VALUE;
            //当前子树的节点数，由于是从最小子树开始递归，因此初始值设置为0
            record[2] = 0;
        }

        Node lBST = postOrder(head.left, record);
        //第n-1次的左子树的最大值
        int lMax = record[0];
        // int lMin = record[1];
        //下一层的左子树的大小
        int lSize = record[2];

        Node rBST = postOrder(head.right, record);
        int rMax = record[0];
        int rMin = record[1];
        //下一层的右子树的大小
        int rSize = record[2];

        if(head.left == lBST && head.right == rBST && lMax < head.data && rMin > head.data){
            record[2] = lSize + rSize + 1;
            return head;
        }else{
            record[2] = Math.max(lSize, rSize);
            return lSize > rSize ? lBST : rBST;
        }
    }
}
