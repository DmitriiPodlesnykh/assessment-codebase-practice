/**
 * Source: https://leetcode.com/problems/find-the-highest-altitude/
 *
 * Time Submitted   | Status   | Runtime| Memory
 * 12/12/2021 15:09	|Accepted  |	0 ms	| 36.4 MB
 *
 * Runtime: faster than 100.00% of submissions. Memory Usage: less than 95.36% of submissions.
 *
 */
public class FindTheHighestAltitude {
  
  public int largestAltitude(int[] gain) {
        int heghestAltitude = 0;
        
        int prevPoint = 0;
        
        for (int i= 0; i< gain.length; i++) {
            int newPoint = gain[i];
            
            prevPoint = prevPoint + newPoint;
            if (heghestAltitude < prevPoint) {
                heghestAltitude = prevPoint;
            }
        }
        
        return heghestAltitude;
        
    }
  
}
