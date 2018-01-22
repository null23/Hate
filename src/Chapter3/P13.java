package Chapter3;
/**
 * Created by mikaelw on 01/22/18.
 */
//判断一棵树是否为平衡二叉树，仍然从子树下手，若子树都不是平衡二叉树，这棵树就一定不是平衡二叉树
public class P13 {
    public class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public boolean isBalance(Node head){
        int level = 1;
        boolean isBalance = true;
        getHeight(head, 1, isBalance);
        return isBalance;
    }

    public int getHeight(Node head, int level, boolean isBalance){
        if(head == null){
            return level;
        }

        int lH = getHeight(head.left, level++, isBalance);
        if(isBalance == false){
            return level;
        }

        int rH = getHeight(head.right, level++, isBalance);
        if(isBalance == false){
            return level;
        }

        int abs = Math.abs(lH - rH);
        if(abs > 1){
            isBalance = false;
        }
        return Math.max(lH, rH);
    }
}
