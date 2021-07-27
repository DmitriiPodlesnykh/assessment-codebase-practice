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



class Result3 {

    /*
     * @param numbers List of numbers
     */
    public static void closestNumbers(List<Integer> numbers) {
        numbers = numbers.stream()
                        .sorted()
                        .collect(Collectors.toList());
        final int minDif = getMinDiff(numbers);
        final List<Pair> resultPairs = preparePairs(numbers, minDif);
        printResult(resultPairs);
    }
    
    private static List<Pair> preparePairs(List<Integer> numbers, int minDif) {
        final List<Pair> result = new ArrayList<>();
        int firstValue = numbers.get(0);
        int secondValue = numbers.get(1);
        for (int i = 0; i<numbers.size(); i++) {
            if (i+1 < numbers.size()) {
                firstValue = numbers.get(i);
                secondValue = numbers.get(i+1);
                if (Math.abs(firstValue - secondValue) == minDif) {
                    result.add(new Pair(firstValue, secondValue));
                }
            }
        }
        return result;
    }
    
    private static void printResult(List<Pair> result) {
        for (Pair p : result) {
            System.out.println(p.getFirstValue() + " " + p.getSecondValue());   
        }
    }
    
    private static int getMinDiff(List<Integer> numbers) {
        int minDif = Integer.MAX_VALUE;
        
        for (int i = 0; i<numbers.size(); i++) {
            if (i+1 < numbers.size()) {
                int diff = Math.abs(numbers.get(i) - numbers.get(i+1));
                if (minDif > diff) {
                    minDif = diff;
                }
            }
        }
        return minDif;
    }

}

class Pair {
    
    private int firstValue;
    
    private int secondValue;
    
    Pair(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }
    
    int getFirstValue() {
        return firstValue;
    }
    
    int getSecondValue() {
        return secondValue;
    }
}
