/**
 * Source: https://leetcode.com/problems/group-anagrams/submissions/
 *
 * Time Submitted   | Status   |Runtime| Memory
 * 12/12/2021 00:10	|Accepted	 | 6 ms	 | 42.2 MB
 *
 * Runtime: Runtime: 6 ms, faster than 83.36% of submissions. Memory Usage: 42.2 MB, less than 66.08%  of submissions.
 *
 */
public class GroupAnagramsSolution {
  
  public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> map = prepareMap(strs);
        
        final List<List<String>> result = new ArrayList<>();
        
        for (List<String> e : map.values()) {
            result.add(e);
        }
        
        return result;
    }
    
    private Map<String, List<String>> prepareMap(String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i< strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (map.containsKey(key)) {
                List<String> value = map.get(key);
                value.add(strs[i]);
                map.put(key, value);
            } else {
                List<String> value = new ArrayList<>();
                value.add(strs[i]);
                map.put(key, value);
            }
        }
        return map;
    }
}
