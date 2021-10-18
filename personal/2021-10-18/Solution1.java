import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.*;


public class Solution1 {
    
    public static void main(String[] args) {
        final List<String> result = DataProvider.prepareInputParams().stream()
        .map(e -> update(e))
        .collect(toList());
        System.out.println("myString is: " + result);
    }
    
    private static String update(InputRecord rec) {//Character.isWhitespace()
        String result = "";
        if (rec.firstParam == FirstParam.S) {
            result = toSeparateWords(rec);
        } else if (rec.firstParam == FirstParam.C) {
            
        }
        return result;
    }
    
    private static String toSeparateWords(InputRecord rec) {
        String result = "";
        String recValue = rec.value;
        for (int i = rec.value.length()-1; i>=0; i--) {
                char c = rec.value.charAt(i);
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


