import java.util.*;

public class DependencyResolution {
    
    public static void main(String[] args) {
        String[][] dependencies = new String[][]{
                // group 1: P0 depends on P1 and so on
                {"P0", "P1"},
                {"P3", "P2"},
                {"P1", "P3"},
                {"P4", "P1"},
                {"P0", "P5"},
                {"P0", "P6"}
                
        };
        
        //
        arePackagesInstallable(dependencies);
    }


    private static boolean arePackagesInstallable(String[][] dependencies) {
        Map<String, List<String>> dep2RelativeMap = new HashMap<>();
        for (int i =0; i<dependencies.length; i++)  {
            String key = dependencies[i][0];
            String value = dependencies[i][1];
            if(dep2RelativeMap.containsKey(key)) {
                List<String> valueList = dep2RelativeMap.get(key);
                valueList.add(value);
                dep2RelativeMap.put(key, valueList);
            } else {
                List<String> valueList = new ArrayList<>();
                valueList.add(value);
                dep2RelativeMap.put(key, valueList);
            }
        }
        
        for (Map.Entry<String, List<String>> e : dep2RelativeMap.entrySet()) {
            
            String key = e.getKey();
            
            for (String valueElement : e.getValue()) {
                
                if (dep2RelativeMap.containsKey(valueElement)) {
                    List<String> valueElementValues = dep2RelativeMap.get(valueElement);
                    for (String v : valueElementValues) {
                        if (key.equals(v)) {
                            return false;
                        }
                    }
                } 
            }
            //System.out.println("key =" + e.getKey() + "; value =  " + e.getValue());
        } 
        
        // for (Map.Entry<String, List<String>> e : dep2RelativeMap.entrySet()) {
        //     System.out.println("key =" + e.getKey() + "; value =  " + e.getValue());
        // } 
        return true;
    }
}

