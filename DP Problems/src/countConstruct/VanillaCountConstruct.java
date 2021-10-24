package countConstruct;

import canConstruct.DynamicCanConstruct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VanillaCountConstruct {
    public static void main(String args[]){
        VanillaCountConstruct vanillaCountConstruct = new VanillaCountConstruct();
        System.out.println(
                vanillaCountConstruct.countConstruct
                        ("purple",
                                Arrays.asList("purp", "p", "ur", "le", "purpl"))); //2
        System.out.println(
                vanillaCountConstruct.countConstruct
                        ("abcdef",
                                Arrays.asList("ab", "abc", "cd", "def", "abcd"))); //1
        System.out.println(
                vanillaCountConstruct.countConstruct
                        ("skateboard",
                                Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar"))); //0
        System.out.println(
                vanillaCountConstruct.countConstruct
                        ("enterapotentpot",
                                Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t"))); //4
        System.out.println(
                vanillaCountConstruct.countConstruct
                        ("eeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                                Arrays.asList("e", "ee", "eee", "eeee", "eeeee"))); //0
    }

    int countConstruct(String targetString, List<String> wordBank){
        if(targetString.equals("")) return 1;

        int count = 0;
        for(String word: wordBank){
            if(targetString.startsWith(word)){
                String newTargetString = targetString.substring(word.length());
                count += countConstruct(newTargetString, wordBank);
            }
        }
        return count;
    }
}
