package Chapter3;
/**
 * Created by mikaelw on 01/16/18.
 */
//最大搜索二叉子树
public class P7 {
    public class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public Node biggestSubBST(Node head){
        int[] record = new int[3];
        return postOrder(head, record);
    }

    public Node postOrder(Node head, int[] record){
        if(head == null){
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
        }
        int value = head.data;
        Node left = head.left;
        Node right = head.right;
        //Node左侧的最大搜索树
        Node lBST = postOrder(left, record);
        int lSize = record[0];
        //第n-1次的左子树最小的值，就是上一次左侧最小
        int lMin = record[1];
        //由于递归的原因，第n-1次的左子树中最大的值，就是上一次的右侧最大
        int lMax = record[2];
        //Node右侧的最大搜索树
        Node rBST = postOrder(right, record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        //record[1]就放左边最小的
        record[1] = Math.min(lMin, value);
        //record[2]就放右边最大的
        record[2] = Math.max(rMax, value);
        if(left == lBST && rBST == rBST && lMax < value && rMin > value){
            record[0] = lSize + rSize + 1;
            return head;
        }
        return lSize > rSize ? lBST : rBST;
    }
}
