package howSum;

import java.util.*;

public class VanillaHowSum {

    public static void main(String args[]) {
        VanillaHowSum vanillaHowSum = new VanillaHowSum();
        System.out.println(vanillaHowSum.howSum(7, Arrays.asList(2,3))); //[3,2,2]
        System.out.println(vanillaHowSum.howSum(7, Arrays.asList(5,3,4,7))); //[4,3]
        System.out.println(vanillaHowSum.howSum(7, Arrays.asList(2,4))); //null
        System.out.println(vanillaHowSum.howSum(8, Arrays.asList(2,3,5))); //[2,2,2,2]
        System.out.println(vanillaHowSum.howSum(300, Arrays.asList(7,14))); //null
    }

    List<Integer> howSum(int sum, List<Integer> array){
        if(sum == 0) return new ArrayList<>();
        if(sum < 0) return null;

        for(int arrayItem: array){
            List<Integer> returnedList = howSum(sum-arrayItem, array);
            if(returnedList != null){
                returnedList.add(arrayItem);
                return returnedList;
            }
        }
        return null;
    }
}
