package howSum;

import java.util.*;

public class DynamicHowSum {
    Map<Integer, List<Integer>> memoizedReturnedList = new HashMap<>();

    public static void main(String args[]) {
        DynamicHowSum dynamicHowSum = new DynamicHowSum();
        System.out.println(dynamicHowSum.howSum(7, Arrays.asList(2,3),new HashMap<>())); //[3,2,2]
        System.out.println(dynamicHowSum.howSum(7, Arrays.asList(5,3,4,7),new HashMap<>())); //[4,3]
        System.out.println(dynamicHowSum.howSum(7, Arrays.asList(2,4),new HashMap<>())); //null
        System.out.println(dynamicHowSum.howSum(8, Arrays.asList(2,3,5),new HashMap<>())); //[2,2,2,2]
        System.out.println(dynamicHowSum.howSum(300, Arrays.asList(7,14),new HashMap<>())); //null


    }

    List<Integer> howSum(int sum, List<Integer> array, Map<Integer, List<Integer>> memoizedReturnedList){
        if(sum == 0) return new ArrayList<>();
        if(sum < 0) return null;
        if(memoizedReturnedList.containsKey(sum)) return memoizedReturnedList.get(sum);

        for(int arrayItem: array){
            List<Integer> returnedList = howSum(sum-arrayItem, array, memoizedReturnedList);
            if(returnedList != null){
                returnedList.add(arrayItem);
                memoizedReturnedList.put(sum, new ArrayList<>(returnedList));
                System.out.println("memo " + memoizedReturnedList);
                return returnedList;
            }
        }
        System.out.println("memo " + memoizedReturnedList);
        memoizedReturnedList.put(sum, null);
        return null;
    }
}

