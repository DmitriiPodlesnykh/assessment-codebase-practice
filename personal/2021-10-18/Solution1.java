import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.*;


public class Solution {
    
    public static void main(String[] args) {
        final List<String> result = DataProvider.prepareInputParams().stream()
        .map(e -> update(e))
        .collect(toList());
        
        result.forEach(e -> System.out.println(e));
    }
    
    private static String update(InputRecord rec) {
        String result = "";
        final String recValue = rec.value;
        if (rec.firstParam == FirstParam.S) {
            result = split(recValue);
        } else if (rec.firstParam == FirstParam.C) {
            result = combine(recValue);
        } else {
            result = recValue;
        }
        
        if (rec.secondParam == SecondParam.M) {
            result = toMethod(result);
        } else if (rec.secondParam == SecondParam.C) {
            result = toClass(result);
        }
        return result;
    }
    
    private static String combine(String value) {
        String result = "";
        for (int i = 0; i<=value.length()-1; i++) {
                char c = value.charAt(i);
                if (Character.isWhitespace(c) ) {
                    i++;
                    result = result + Character.toUpperCase(value.charAt(i));
                } else {
                    result = result + c;
                }
        }
        return result;
    }
    
    private static String toClass(String value) {
        String result = value;
        if (Character.isWhitespace(result.charAt(0)) ) {
            return result.substring(1);
        } else if (Character.isLowerCase(result.charAt(0))) {
            return Character.toUpperCase(result.charAt(0)) + result.substring(1);
        } else {
            return result;
        }
    }
    
    private static String toMethod(String value) {
        if (value.contains("()")) {
            return value;
        } else {
            return value + "()";
        }
    }
    
    private static String split(String value) {
        String result = "";
        for (int i = value.length()-1; i>=0; i--) {
                char c = value.charAt(i);
                if (Character.isUpperCase(c) ) {
                    result = result + Character.toLowerCase(c) + " ";
                } else {
                    result = result + c;
                }
        }
        return new StringBuilder(result).reverse().toString();
    }
    
}

class DataProvider {
    static List<InputRecord> prepareInputParams() {
        final Scanner scanner = new Scanner(System.in);
        final List<InputRecord> result = new ArrayList<>();
        while(scanner.hasNext()) {
            result.add(convert(scanner.nextLine()));
        }
        scanner.close();
        return result;
    }
    
    static InputRecord convert(String s) {
        final String[] arr = s.split(";");
        return new InputRecord(
            FirstParam.valueOf(arr[0]), 
            SecondParam.valueOf(arr[1]), 
            arr[2]);
    }
}

enum FirstParam {
    C,S;   
}

enum SecondParam {
    M, C, V;
}

class InputRecord {
    
    public final FirstParam firstParam;
    
    public final SecondParam secondParam;
    
    public final String value;
    
    public InputRecord(FirstParam firstParam, SecondParam secondParam, String value) {
        this.firstParam = firstParam;
        this.secondParam = secondParam;
        this.value = value;
    }
    
    public String toString() {
        return "InputRecord { firstParam = " 
        + firstParam 
        + "; secondParam = " 
        + secondParam 
        + "; value = " 
        + value + "}";
    }
}


