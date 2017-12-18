package Chapter1;

import java.util.LinkedList;

/**
 * Created by LENOVO on 2017/12/16.
 */
public class P7 {
    public int[] getMaxWindow(int[] arr, int w){
        if(arr == null || w < 1 || arr.length < w){
            return null;
        }
        //双端队列
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int res[] = new int[arr.length - w + 1];
        int index = 0;
        for(int i = 0; i < arr.length; i++ ){
            //peekLast()检索最后一个元素，pollLast()移除最后一个元素
            //双端队列不为空，并且队尾元素小于等于arr[i]
            while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            //窗口过期：队列头超过当前窗口第一个
            if(qmax.peekFirst() == i - w){
                qmax.peekFirst();
            }
            if(i > w - 1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
