package Chapter5;
/**
 * Created by mikaelw on 01/29/18.
 */
public class P5 {
    public boolean isValid(char[] chas){
        if(chas == null){
            return false;
        }
        if(chas[0] != '-' && (chas[0] < '0' || chas[0] > '9')){
            return false;
        }
        if(chas[0] != '-' && (chas.length == 1 || chas[1] == 0)){
            return false;
        }
        if(chas[0] == '0' && chas.length == 1){
            return false;
        }
        for(int i = 0; i < chas.length; i++){
            if(chas[0] < '0' || chas[0] > '9'){
                return false;
            }
        }
        return true;
    }
}
