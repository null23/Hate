package Chapter5;
/**
 * Created by mikaelw on 01/29/18.
 */
public class P2 {
    public int numSum(String str){
        if(str == null){
            return 0;
        }
        //当前连续的字符数字
        int num = 0;
        //几个字符串的和
        int res = 0;
        //加还是减
        boolean posi = true;
        char[] s = str.toCharArray();
        int cur = 0;
        for(int i = 0; i < s.length; i++){
            cur = s[i] - '0';
            if(cur < 0 || cur > 9){
                res += num;
                num = 0;
                if(cur == '-'){
                    if(s[i - 1] == '-'){
                        posi = !posi;
                    }else{
                        posi = false;
                    }
                }
            }else{
                num = num * 10 + (posi ? cur : (-cur));
            }
        }
        res += num;
        return res;
    }
}
