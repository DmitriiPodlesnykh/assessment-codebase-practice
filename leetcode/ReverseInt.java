class ReverseInt {
 public int reverse(int x) {
        String stringValue = String.valueOf(x);
        if (x<0) {
            stringValue = stringValue.substring(1);
            return Integer.parseInt("-"+revertInt(stringValue));
        } else {
            String result = revertInt(stringValue);
            return (int) Long.parseLong(result);
        }
    }
    
    private String revertInt(String s) {
        char [] resultArray = new char[s.length()];
        char a;
        for(int i = 0; i<s.length(); i++) {
            resultArray[i] = s.charAt(s.length()-1-i);
            resultArray[s.length()-1-i] = s.charAt(i);
        }
        if (Integer.MAX_VALUE >= Long.parseLong(String.valueOf(resultArray))) {
            return String.valueOf(resultArray);
        } else {
            return "0";
        }
    }
}
