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
     * Shifted String
     *  @param s String
     *  @param leftShifts int
     *  @param rightShifts int
     */

    public static String getShiftedString(String s, int leftShifts, int rightShifts) {
        final int finalShifts = leftShifts - rightShifts;
        
        final boolean isLeftShift = finalShifts > 0 ? false : true;
        
        final int clearShifts = getClearAbsShifts(s, finalShifts);
        
         if(clearShifts == 0) {
             return s;
         } else if (!isLeftShift) {
             return getLeftShiftedString(s, clearShifts);
         } else {
             return getRightShiftedString(s, clearShifts);
         }
    }
    
    private static int getClearAbsShifts(String s, final int finalShifts) {
        final int absFinalShifts = Math.abs(finalShifts);
        final int sLength = s.length();
        if (absFinalShifts < sLength) {
            return absFinalShifts;
        } else if (absFinalShifts > sLength && absFinalShifts%sLength == 0) {
            return 0;
        } else {
            int loopShifts = absFinalShifts/sLength;
            int clearShifts = absFinalShifts - (loopShifts*sLength);
            return clearShifts;
        }
    }
    
    
    private static String getLeftShiftedString(String s, int shifts)  {
        for (int i = 0; i< shifts; i++) {
            s= s.substring(1, s.length()) + s.charAt(0) ;
        }
        return s;
    }
    
    private static String getRightShiftedString(String s, int shifts)  {
        String rightSubString = s.substring(s.length() - shifts, s.length());
        String leftSubString = s.substring(0, s.length() - shifts);
        return rightSubString + leftSubString;
    }

}
