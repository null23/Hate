package Chapter5;
/**
 * Created by mikaelw on 01/30/18.
 */
public class P7 {
    public String getCountString(String str){
        if(str == null){
            return str;
        }
        char[] s = str.toCharArray();
        String res = String.valueOf(s[0]);

        int num = 1;
        for(int i = 1 ;i < str.length(); i++){
            if(s[i] == s[i-1]){
                num++;
            }else{
                res = res + s[i] + "_" + num;
                num = 1;
            }
        }
        return res + "_" + String.valueOf(num);
    }
}
