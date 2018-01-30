package Chapter5;
/**
 * Created by mikaelw on 01/30/18.
 */
public class P6 {
    public String replace(String str, String form, String to){
        if(str == null || form == null || to.equals("") || form.equals("")){
            return str;
        }
        char[] cStr = str.toCharArray();
        char[] cForm = form.toCharArray();

        int match = 0;
        for(int i = 0; i < cStr.length; i++){
            //最重要的就是这个match++，在判断条件内对match进行累加，就能不进入if进去对match进行累加了
            if(cStr[i] == cForm[match++]){
                if(match == cForm.length){
                    //说明有匹配的，把匹配的位置置换成0
                    for(int j = i; j < cForm.length; j--){
                        cStr[j] = 0;
                    }
                }
            }else{
                match = 0;
            }
        }

        String res = "";
        String cur = "";
        for(int i = 0; i < cStr.length; i++){
            if(cStr[i] != '0'){
                cur = cur + String.valueOf(cStr[i]);
            }
            if(cStr[i] == '0' && (cStr[i - 1] != '0')){
                res = res + cur + to;
            }
        }
        if(!cur.equals("")){
            res = res + cur;
        }

        return res;
    }
}
