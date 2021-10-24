package countConstruct;

import canConstruct.DynamicCanConstruct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicCountConstruct {
    public static void main(String args[]){
        DynamicCountConstruct dynamicCountConstruct = new DynamicCountConstruct();
        System.out.println(
                dynamicCountConstruct.countConstruct
                        ("purple",
                                Arrays.asList("purp", "p", "ur", "le", "purpl"))); //2
        System.out.println(
                dynamicCountConstruct.countConstruct
                        ("abcdef",
                                Arrays.asList("ab", "abc", "cd", "def", "abcd"))); //1
        System.out.println(
                dynamicCountConstruct.countConstruct
                        ("skateboard",
                                Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar"))); //0
        System.out.println(
                dynamicCountConstruct.countConstruct
                        ("enterapotentpot",
                                Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t"))); //4
        System.out.println(
                dynamicCountConstruct.countConstruct
                        ("eeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                                Arrays.asList("e", "ee", "eee", "eeee", "eeeee"))); //0
    }

    int countConstruct(String targetString, List<String> wordBank){
        return countConstruct( targetString,  wordBank, new HashMap<>());
    }

    int countConstruct(String targetString, List<String> wordBank, Map<String, Integer> memoizedCanConstruct){
        if(targetString.equals("")) return 1;
        if(memoizedCanConstruct.containsKey(targetString)) return memoizedCanConstruct.get(targetString);

        int count = 0;
        for(String word: wordBank){
            if(targetString.startsWith(word)){
                String newTargetString = targetString.substring(word.length());
                count += countConstruct(newTargetString, wordBank, memoizedCanConstruct);
            }
        }

        memoizedCanConstruct.put(targetString, count);
        return count;
    }
}
