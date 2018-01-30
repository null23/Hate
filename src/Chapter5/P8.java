package Chapter5;
/**
 * Created by mikaelw on 01/30/18.
 */
public class P8 {
    public boolean isUnique(char[] chars){
        boolean[] map = new boolean[256];
        for(int i = 0; i < chars.length; i++){
            if(map[chars[i]]){
                return false;
            }
            map[chars[i]] = true;
        }
        return true;
    }
}
