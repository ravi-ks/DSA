package IsSumPossible;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicIsSumPossible {
    public static void main(String args[]) {
        DynamicIsSumPossible dynamicIsSumPossible = new DynamicIsSumPossible();
        System.out.println(dynamicIsSumPossible.isSumPossible(3000, List.of(7, 14), new HashMap<>()));
    }

    Boolean isSumPossible(int sum, List<Integer> array,Map<Integer, Boolean> memoizedIsSumPossible){
        if(sum == 0) return true;
        if(sum < 0) return false;

        if(memoizedIsSumPossible.containsKey(sum)){
            //System.out.println("Log: " + sum);
            return memoizedIsSumPossible.get(sum);
        }

        for(Integer arrayItem: array) {
            if (isSumPossible(sum - arrayItem, array, memoizedIsSumPossible)) {
                //System.out.println("Memoizing true " + sum);
                memoizedIsSumPossible.put(sum, true);
                return true;
            }
        }
        //System.out.println("Memoizing false " + sum);
        memoizedIsSumPossible.put(sum, false);
        return false;
    }
}

//T = O(n), n is the sum
//S = O(n), n is the sum
