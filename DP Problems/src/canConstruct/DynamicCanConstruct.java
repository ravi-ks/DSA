package canConstruct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicCanConstruct {
    public static void main(String args[]){
        DynamicCanConstruct dynamicCanConstruct = new DynamicCanConstruct();
        System.out.println(
                dynamicCanConstruct.canConstruct
                        ("abcdef",
                                Arrays.asList("ab", "abc", "cd", "def", "abcd"))); //true
        System.out.println(
                dynamicCanConstruct.canConstruct
                        ("skateboard",
                                Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar"))); //false
        System.out.println(
                dynamicCanConstruct.canConstruct
                        ("enterapotentpot",
                                Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t"))); //true
        System.out.println(
                dynamicCanConstruct.canConstruct
                        ("eeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                                Arrays.asList("e", "ee", "eee", "eeee", "eeeee"))); //false
    }

    boolean canConstruct(String targetString, List<String> wordBank){
        return  canConstruct( targetString,  wordBank, new HashMap<>());
    }

    boolean canConstruct(String targetString, List<String> wordBank, Map<String, Boolean> memoizedCanConstruct){
        if(targetString.equals("")) return true;
        if(memoizedCanConstruct.containsKey(targetString)) return memoizedCanConstruct.get(targetString);


        for(String word: wordBank){
            if(targetString.startsWith(word)){
                String newTargetString = targetString.substring(word.length());
                if(canConstruct(newTargetString, wordBank, memoizedCanConstruct)) {
                    memoizedCanConstruct.put(newTargetString, true);
                    return true;
                }
            }
        }
        memoizedCanConstruct.put(targetString, false);
        return false;
    }
}
