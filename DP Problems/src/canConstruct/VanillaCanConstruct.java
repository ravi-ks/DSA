package canConstruct;

import java.util.Arrays;
import java.util.List;

public class VanillaCanConstruct {
    public static void main(String args[]){
        VanillaCanConstruct vanillaCanConstruct = new VanillaCanConstruct();
        System.out.println(
                vanillaCanConstruct.canConstruct
                        ("abcdef",
                                Arrays.asList("ab", "abc", "cd", "def", "abcd"))); //true
        System.out.println(
                vanillaCanConstruct.canConstruct
                        ("skateboard",
                                Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar"))); //false
        System.out.println(
                vanillaCanConstruct.canConstruct
                        ("enterapotentpot",
                                Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t"))); //true
        System.out.println(
                vanillaCanConstruct.canConstruct
                        ("eeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                                Arrays.asList("e", "ee", "eee", "eeee", "eeeee"))); //false
    }

    boolean canConstruct(String targetString, List<String> wordBank){
        if(targetString.equals("")) return true;

        for(String word: wordBank){
            if(targetString.startsWith(word)){
                if(canConstruct(targetString.substring(word.length()), wordBank))
                    return true;
            }
        }
        return false;
    }
}
