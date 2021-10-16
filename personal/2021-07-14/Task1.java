// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Arrays;

class Solution {
    public String solution(String riddle) {
        final char[] riddleChar = riddle.toCharArray();

        for (int i = 0; i< riddleChar.length; i++) {
            if (riddleChar[i] == '?') {
                if (i == 0) {
                    riddleChar[i] = prepareReplacementCharacter('#', riddleChar[i+1]);
                } else if (i == riddleChar.length - 1) {
                    riddleChar[i] = prepareReplacementCharacter(riddleChar[i-1], '#');
                } else {
                    riddleChar[i] = prepareReplacementCharacter(riddleChar[i-1], riddleChar[i+1]);
                }
            }
        }
        return new String(riddleChar);
        // write your code in Java SE 8
    }

    private char prepareReplacementCharacter(char prevChar, char nextChar) {
        for(char charValue = 'a'; charValue <= 'z'; ++charValue) {
            if (prevChar != charValue && nextChar != charValue) {
                return charValue;
            }
        }
        return '#';
    }
//3 tests passed
}
