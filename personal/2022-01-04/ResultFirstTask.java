class ResultFirstTask {

    /*
     * Complete the 'find_doubles_in_list' function below.
     *
     * The function accepts INTEGER_ARRAY values as parameter.
     */

    public static void find_doubles_in_list(List<Integer> values) {
        List<Integer> result = new ArrayList<>();
        
        Map<Integer, Integer> valueCount = new HashMap<>();
        
        for (Integer value : values) {
            if (valueCount.containsKey(value)) {
                Integer countValue = valueCount.get(value);
                countValue++;
                valueCount.put(value, countValue);
            } else {
                valueCount.put(value, 1);
            }
        }
        
        for (Integer value : values) {
            
            Integer doubleValue = value*2;
            
            if (valueCount.containsKey(doubleValue) 
                && (valueCount.get(doubleValue) == 1)) {
                    result.add(value);
                }
        }
        result = result.stream().sorted().collect(Collectors.toList());   
    
        for (Integer e : result) {
            System.out.print(e + " ");
        }
        
    }

}
