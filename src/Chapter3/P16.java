package Chapter3;
/**
 * Created by mikaelw on 01/25/18.
 */
public class P16 {
    public class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public Node generateTree(int[] sortArr){
        if(sortArr == null || sortArr.length == 0){
            return null;
        }
        return generate(sortArr, 0, sortArr.length - 1);
    }

    public Node generate(int[] arr, int start, int end){
        if(start > end){
            return null;
        }
        Node head = new Node(arr[end]);
        int less = -1;
        int more = end;

        //less和more把当前数组段分为两颗左右子树
        for(int i = start; i < end; i++){
            if(head.data > arr[i]){
                less = i;
            }else{
                more = more == end ? i : more;
            }
        }

        head.left = generate(arr, start, less);
        head.right = generate(arr, more, end - 1);

        return head;
    }
}
