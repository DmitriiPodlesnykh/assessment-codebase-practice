// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
    private static final Map<Integer, List<Integer>> sameNumbersSumValuesMap = new HashMap<>();

    public int solution(int[] A) {
        boolean isExistPair = false;
        for (int j : A) {
            int numberSum = getNumberSum(j);
            if (sameNumbersSumValuesMap.containsKey(numberSum)) {
                isExistPair = true;
                List<Integer> value = sameNumbersSumValuesMap.get(numberSum);
                value.add(j);
                sameNumbersSumValuesMap.put(numberSum, value);
            } else {
                List<Integer> value = new ArrayList<>();
                value.add(j);
                sameNumbersSumValuesMap.put(numberSum,  value);
            }
        }
        if(!isExistPair) {
            return -1;
        }

        List<Integer> resultSum = new ArrayList<>();
        for (List<Integer> integers : sameNumbersSumValuesMap.values()) {
            if (integers.size() == 2) {
                resultSum.add(integers.get(0) + integers.get(1));
            } else if (integers.size() >2) {
                resultSum.add(getMaxValue(integers) + get2ndMaxValue(getMaxValue(integers), integers));
            }
        }

        return resultSum.stream().max(Integer::compareTo).orElse(-1);
    }

    private int getMaxValue(List<Integer> integers) {
        return integers.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    private int get2ndMaxValue(int maxValue, List<Integer> integers) {
        return integers.stream()
                .filter(integer -> integer != maxValue)
                .max(Integer::compareTo)
                .orElse(0);
    }

    private int getNumberSum(int a) {
        return String.valueOf(a)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
