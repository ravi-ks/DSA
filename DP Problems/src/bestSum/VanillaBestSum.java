package bestSum;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class VanillaBestSum {
    public static void main(String args[]) {
        VanillaBestSum vanillaBestSum = new VanillaBestSum();
        System.out.println(vanillaBestSum.bestSum(7, List.of(5,3,4,7))); //[7]
        System.out.println(vanillaBestSum.bestSum(8, List.of(2,3,5))); //[3,5]
        System.out.println(vanillaBestSum.bestSum(8, List.of(1,4,5))); //[4,4]
        System.out.println(vanillaBestSum.bestSum(100, List.of(1,2,5,25))); //[25,25,25,25]
        System.out.println(vanillaBestSum.bestSum(10, List.of(1, 2, 5, 25))); //[25,25,25,25]

    }

    List<Integer> bestSum(int sum, List<Integer> array){
        if(sum == 0)
            return new ArrayList<>();
        if(sum < 0)
            return null; //impossible to derive at the sum

        //stores list with min size which can derive the sum provided in this function's parameter
        List<Integer> bestSumList = new ArrayList<>();

        for(Integer arrayItem: array){
            List<Integer> returnList = bestSum(sum-arrayItem, array);

            if(returnList != null){
                returnList.add(arrayItem);
                if(bestSumList.size() == 0 || returnList.size() < bestSumList.size())
                    bestSumList = returnList;
            }
        }
        //System.out.println("sum: " + sum + "\nbestSumList" + bestSumList);
        if(bestSumList.size() == 0)
            return null;
        return bestSumList;
    }
}
