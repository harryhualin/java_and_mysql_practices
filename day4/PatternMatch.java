package day4;

import java.util.HashMap;
public class PatternMatch {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character , String > map = new HashMap();
        String[] temp = str.split("\\s");
        char[] c = pattern.toCharArray();
        if(temp.length != c.length)
            return false;

        for(int i = 0 ; i<temp.length ; i++){
            if(!map.containsKey(c[i])){
                if(map.containsValue(temp[i]))
                    return false;
                map.put(c[i] , temp[i]);
            }else{
                if(!map.get(c[i]).equals(temp[i]))
                    return false;
            }
        }
        return true;
    }
}
