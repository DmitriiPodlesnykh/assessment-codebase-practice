import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class ResultSecondTask {

    /*
     * Complete the 'findTotalImbalance' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY rank as parameter.
     */

    public static long findTotalImbalance(List<Integer> rank) {
    // Write your code here
        long imbalancedCountResult = 0;
    
        boolean isCompleted = false;
    
        int countOfElements = 1;
        int startFromIndex = 0;
        while(!isCompleted) {
            
            final List<Integer> preparedList = prepareList(rank, countOfElements, startFromIndex);
            if (isImbalanced(preparedList)) {
                imbalancedCountResult++;
            }
            
            if (countOfElements + startFromIndex < rank.size()) {
                startFromIndex++;
            } else {
                startFromIndex = 0;
                countOfElements++;
            }
        
            if(countOfElements == rank.size()) {
                isCompleted = true;
            }
        }
    
        return imbalancedCountResult;
    }
    
    private static List<Integer> prepareList(List<Integer> rank, int countOfElements, int startFromIndex) {
        if (rank.size() == 1) {
            return rank;
        }
        final List<Integer> result = new ArrayList<>();
        
        for (int i=startFromIndex; i<countOfElements; i++) {
            if (startFromIndex < rank.size()) {
                result.add(rank.get(i));
            }
        }
        return result.stream()
        .sorted()
        .collect(Collectors.toList());
    }
    
    private static boolean isImbalanced(List<Integer> preparedList) {
        if (preparedList == null || preparedList.size() <2) {
            return false;
        }
        int element = preparedList.get(0);
        
        for (int i=0; i<preparedList.size(); i++) {
            long diff = preparedList.get(i) - element ;
            if (diff >1) {
                return true;
            } 
        }
        return false;
    }

}
