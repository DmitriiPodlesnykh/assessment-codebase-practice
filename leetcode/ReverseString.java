class ReverseString {
    public void reverseString(char[] s) {
        char a;
        for (int i=0; i<s.length/2; i++) {
            a = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = a;
        }
    }
}
