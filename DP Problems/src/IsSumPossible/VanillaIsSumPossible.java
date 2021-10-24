package IsSumPossible;

import java.util.ArrayList;
import java.util.List;

//Array elements can be used more than once to derive the sum
public class VanillaIsSumPossible {
    public static void main(String args[]) {
        VanillaIsSumPossible vanillaIsSumPossible = new VanillaIsSumPossible();
        System.out.println(vanillaIsSumPossible.isSumPossible(300, List.of(7, 14)));
    }

    Boolean isSumPossible(int sum, List<Integer> array){
        if(sum == 0) return true;
        if(sum < 0) return false;
        for(Integer arrayItem: array) {
            if (true == isSumPossible(sum - arrayItem, array))
                return true;
        }
        return false;
    }
}
