package Chapter5;
/**
 * Created by mikaelw on 01/29/18.
 */
public class P4 {
    public boolean isRotation(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() != str2.length()){
            return false;
        }
        String add = str1 + str2;

        return add.contains(str1);
    }
}
