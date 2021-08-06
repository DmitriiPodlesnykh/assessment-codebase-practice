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
     * Complete the 'budgetShopping' function below.
     */
    public static int budgetShopping(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {
        System.out.println("n = " + n);
        List<StoreInformation> resultList = new ArrayList<>(); 
        for (int i = 0; i<bundleQuantities.size(); i++) {
            StoreInformation info = new StoreInformation(bundleQuantities.get(i), bundleCosts.get(i));
            resultList.add(info);
        }
        resultList.sort(new CheapestOneNotebookComparator());
        
        int resultCount = 0;
        
        int currentIndex = 0;
        int nextCost = resultList.get(currentIndex).bundleCosts;
        
        for (StoreInformation i : resultList) { 
            System.out.println("i = " + i);
        }
        while (true) {
            if (currentIndex >= resultList.size()) {
                System.out.println("return" +  resultCount);
                return resultCount;
            }
            if (n >= nextCost) {
                n = n - nextCost;
                resultCount = resultCount + resultList.get(currentIndex).bundleQuantities;
            } else {
                currentIndex++;
            }
        }
        
    }
    
    static class CheapestOneNotebookComparator implements Comparator<StoreInformation> {
        
        public int compare(StoreInformation first, StoreInformation second) {
            return Double.compare(first.oneNotebookCost, second.oneNotebookCost);
        }
    }
    
    
    static class StoreInformation {
        
        int bundleQuantities;
        
        int bundleCosts;
        
        double oneNotebookCost;
        
        StoreInformation(Integer bundleQuantities, Integer bundleCosts) {
            this.bundleQuantities = bundleQuantities;
            this.bundleCosts = bundleCosts;
            this.oneNotebookCost = calculateOneNotebookPrice(this);
        }
        
        public String toString() {
            return "StoreInformation: bundleQuantities = " + bundleQuantities + "; bundleCosts = " + bundleCosts + "; oneNotebookCost = " + calculateOneNotebookPrice(this);   
        }
        
        private double calculateOneNotebookPrice(StoreInformation info) {
            double cost = Double.valueOf(info.bundleCosts);
            double quantities = Double.valueOf(info.bundleQuantities);
            return cost/quantities;
        }
    }
}
