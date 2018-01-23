package Chapter3;
/**
 * Created by mikaelw on 01/23/18.
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
        boolean isPostArray = isPost();
        return isPostArray;
    }

    public boolean isPost(){
        // if(){
        //
        // }
    }
}
