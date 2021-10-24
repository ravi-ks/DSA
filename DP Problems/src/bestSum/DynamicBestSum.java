package bestSum;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicBestSum {
    public static void main(String args[]) {
        DynamicBestSum dynamicBestSum = new DynamicBestSum();
        System.out.println(dynamicBestSum.bestSum(7, List.of(5, 3, 4, 7))); //[7]
        System.out.println(dynamicBestSum.bestSum(8, List.of(2, 3, 5))); //[3,5]
        System.out.println(dynamicBestSum.bestSum(8, List.of(1, 4, 5))); //[4,4]
        System.out.println(dynamicBestSum.bestSum(100, List.of(1, 2, 5, 25))); //[25,25,25,25]
    }

    List<Integer> bestSum(int sum, List<Integer> array) {
        return bestSum(sum, array, new HashMap<>());
    }

    List<Integer> bestSum(int sum, List<Integer> array, Map<Integer, List<Integer>> memoizedBestSum) {
        if (sum == 0)
            return new ArrayList<>();
        if (sum < 0)
            return null; //impossible to derive at the sum
        if (memoizedBestSum.containsKey(sum)) {
            return memoizedBestSum.get(sum);
        }

        //stores list with min size which can derive the sum provided in this function's parameter
        List<Integer> bestSumList = new ArrayList<>();

        for (Integer arrayItem : array) {
            List<Integer> returnList = bestSum(sum - arrayItem, array, memoizedBestSum);

            if (returnList != null) {
                //returnList.add(arrayItem); and then if statement - caused issue.
                List<Integer> newList = new ArrayList<>(returnList);
                newList.add(arrayItem);
                if (bestSumList.size() == 0 || newList.size() < bestSumList.size()) {
                    bestSumList = newList;
                }
            }
        }
        if (bestSumList.size() == 0) {
            memoizedBestSum.put(sum, null);
            return null;
        }
        memoizedBestSum.put(sum, new ArrayList<>(bestSumList));
        //System.out.println("Map key " + sum + " value is " + bestSumList);
        //System.out.println("sum: " + sum + "\nbestSumList: " + bestSumList + "\nmemo: " + memoizedBestSum);
        return bestSumList;
    }
}


