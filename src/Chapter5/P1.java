package Chapter5;
/**
 * Created by mikaelw on 01/29/18.
 */
public class P1 {
    public boolean isDeformation(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() != str2.length()){
            return false;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[] map = new int[256];

        for(int i = 0; i < s1.length; i++){
            map[s1[i]]++;
        }

        for(int i = 0; i < s2.length; i++){
            if(--map[s2[i]] < 0){
                return false;
            }
        }
        return true;
    }
}
