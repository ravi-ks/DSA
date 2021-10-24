package gridTraveler;

import java.util.HashMap;
import java.util.Map;

public class DynamicGridTraveler {
    public static void main(String args[]) {
        DynamicGridTraveler dynamicGridTraveler = new DynamicGridTraveler();
        System.out.println(dynamicGridTraveler.gridTraveler(1,1, new HashMap<>())); //1
        System.out.println(dynamicGridTraveler.gridTraveler(2,3, new HashMap<>())); //3
        System.out.println(dynamicGridTraveler.gridTraveler(3,2, new HashMap<>())); //3
        System.out.println(dynamicGridTraveler.gridTraveler(3,3, new HashMap<>())); //6
        System.out.println(dynamicGridTraveler.gridTraveler(18,18, new HashMap<>())); //2333606220

    }

    long gridTraveler(int row, int col, Map<Pair<Integer, Integer>, Long> memoizedNoOfWays) {
        if(row == 0 || col == 0) return 0; //invalid grid
        if(row == 1 && col == 1) return 1; //positive base case

        Pair<Integer, Integer> dummyKeyPair = new Pair<Integer, Integer>(row, col);
        Pair<Integer, Integer> dummyKeyPairReversed = new Pair<Integer, Integer>(col, row);
        //because noOfWays to reach destn in 2*3 rectangle is same as in 3*2 rectangle

        //System.out.println("dummyKeyPair:" + dummyKeyPair + ", memo: " + memoizedNoOfWays + ", euqals? " +
        //       memoizedNoOfWays.containsKey(dummyKeyPair));
        if(memoizedNoOfWays.containsKey(dummyKeyPair)) {
            //System.out.println("Memo used");
            return memoizedNoOfWays.get(dummyKeyPair);
        }
        if(memoizedNoOfWays.containsKey(dummyKeyPairReversed)) {
            //System.out.println("Memo used");
            return memoizedNoOfWays.get(dummyKeyPairReversed);
        }

        long noOfWaysReturned = gridTraveler(row-1, col, memoizedNoOfWays) + gridTraveler(row, col-1, memoizedNoOfWays);
        memoizedNoOfWays.put(dummyKeyPair, noOfWaysReturned);
        return noOfWaysReturned;
    }
}
