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

    /*
     * Complete the 'reassignedPriorities' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY priorities as parameter.
     */

    public static List<Integer> reassignedPriorities(List<Integer> priorities) {
        final long countPriorities = priorities.stream().distinct().count();
        
        ArrayList<Integer> list = new ArrayList<>(priorities);
        for (long l = 0L; l < countPriorities; l++ ) {
            Map<Long, Integer> priorityLevelPriorityNumber = new HashMap<>();
            
            int value = list.stream().min((o1, o2) -> (o1>o2));
            
            priorityLevelPriorityNumber.put(l, value)
            
        }
    }

}
