package Chapter3;
/**
 * Created by mikaelw on 01/23/18.
 */

/**
 * 根据后序遍历数组重建搜索二叉树
 * 这道题的思路：记得总结过的规律吗？
 * 寻找一颗树的整体性质，应该从最小的子树开始寻找
 * 既然我们要判断一个数组是否是二叉树的后序遍历结果
 * 那我们可以从最大的一整颗树开始
 * 然后把最后一个节点根节点(遍历顺序左右根，因此最后一个节点是根节点),左子树，右子树依次分解
 * 然后分别把左子树和右子树作为下一个整颗的子树
 * 以此类推
 * 只要有一颗子树不符合后序遍历结果的，那么就说明整颗树不符合后序遍历结果
 */
public class P14 {
    public class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public boolean isPostArray(int[] arr){
        if(arr.length == 0 || arr == null){
            return false;
        }
        boolean isPostArray = isPost(arr, 0, arr.length);
        return isPostArray;
    }

    //[2 1 3 6 5 7 4]
    //[2 1 3 4] less = -1
    //[6 5 7 4] more = end
    public boolean isPost(int[] arr, int start, int end){
        if(start == end){
            return true;
        }
        //more和less是纪录大小分隔的临界点
        int less = -1;
        int more = end;
        for(int i = start; i < end; i++){
            if(arr[end] > arr[i]){
                less = i;
            }else{
                more = more == end ? i : more;
            }
        }

        if(less == -1 || more == end){
            return isPost(arr, start, end - 1);
        }

        if(less != more - 1){
            return false;
        }

        return isPost(arr, start, less) && isPost(arr, more, end - 1);
    }

    //根据后序遍历数组重组二叉树
    public Node postArrayToBST(int[] arr){
        if(arr == null && arr.length == 0){
            return null;
        }
        return postToBST(arr, 0, arr.length - 1);
    }

    public Node postToBST(int[] arr, int start, int end){
        if(start > end){
            return null;
        }
        Node head = new Node(arr[end]);

        int less = -1;
        int more = end;

        for(int i = start; i < end ; i++){
            if(arr[end] > arr[i]){
                less = i;
            }else{
                more = more == end ? i : more;
            }
        }


        head.left = postToBST(arr, start, less);
        head.right = postToBST(arr, more, end - 1);

        return head;
    }
}
