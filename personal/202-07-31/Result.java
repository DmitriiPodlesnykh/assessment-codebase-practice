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

class Result {

    public static int minOperations(List<Integer> arr, int threshold, int d) {
        int counter = 0;
        final SortedMap<Integer, Integer> numberCountMap = prepareArrValueCountMap(arr);
        
        for (Integer i : numberCountMap.values()) {
            if (i >= threshold) {
                return 0;
            }
        }
        
        int q = 0;
        while(true) {
            q++;
            int key = numberCountMap.firstKey();
            int dkey = key/d;
            
            System.out.println("q= " + q + ";key = " + key + "; dkey = " + dkey);
            
            if (numberCountMap.containsKey(dkey) ) {
                int keyValue = numberCountMap.get(key);
                int dkeyValue = numberCountMap.get(dkey);
                
                int newDkeyValue = keyValue + dkeyValue;
                
                numberCountMap.remove(key);
                numberCountMap.put(dkey, newDkeyValue);
                
                counter = counter + dkeyValue;
                
                if (newDkeyValue >= threshold) {
                    return counter;
                }
            } else {
                int keyValue = numberCountMap.get(key);
                numberCountMap.put(dkey, keyValue);
                numberCountMap.remove(key);
                counter = counter+ keyValue;
            }
        }
    }
    
    private static SortedMap<Integer, Integer> prepareArrValueCountMap(List<Integer> arr) {
        final SortedMap<Integer, Integer> numberCount = new TreeMap<>(Comparator.reverseOrder());
        for(Integer arrValue : arr) {
            int newValue;
            if (numberCount.containsKey(arrValue)) {
                newValue = numberCount.get(arrValue) + 1;
            } else {
                newValue = 1;
            }
            numberCount.put(arrValue, newValue);
        }
        return numberCount;
    }

}
