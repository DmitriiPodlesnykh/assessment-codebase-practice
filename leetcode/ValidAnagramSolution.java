
/**
* Time Submitted   | Status   | Runtime| Memory
* 12/11/2021 14:35 | Accepted |	2 ms	 | 39.1 MB
*
* Runtime: faster than 95.56% of submissions. Memory Usage: less than 82.06% of submissions.
*
*/
class ValidAnagramSolution {
  
    public boolean isAnagram(String firstString, String secondString) {
        if (firstString.length() != secondString.length()) {
            return false;
        }
        final char[] firstCharArray = firstString.toCharArray();
        final char[] secondCharArray = secondString.toCharArray();
        
        Arrays.sort(firstCharArray);
        Arrays.sort(secondCharArray);
        
        for (int i = 0; i< firstCharArray.length; i++) {
            
            if (firstCharArray[i] != secondCharArray[i]) {
                return false;
            }
        }
        return true;
    }
}



/**
* Time Submitted   | Status             | Runtime| Memory
* 12/06/2021 12:59 |Time Limit Exceeded	| N/A    |	N/A
*
*/
class OldValidButNotEffectiveValidAnagramSolution {
  
  public boolean isAnagram(String firstString, String secondString) {
    for (int i = 0 ; i< firstString.length(); i++) {
      char c = firstString.charAt(i);
      int indexSecStringChar = secondString.indexOf(c);
            
      String newSecString = "";
      if (secondString.length() == 0) {
        return false;
      }
      for (int j = 0; j< secondString.length(); j++) {
        if (indexSecStringChar != j) {
          newSecString = newSecString + secondString.charAt(j);
        }
      }
      secondString = newSecString;
      }
      if (secondString.length()== 0) {
        return true;
      } else {
        return false;
      }
  }
}
