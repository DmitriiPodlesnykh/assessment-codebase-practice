package hackerrank11;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder11 implements FurnitureOrderInterface11 {
 
    private Map<Furniture, Integer> furnitureItemsCountMap;
    
    FurnitureOrder() {
        furnitureItemsCountMap = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        furnitureItemsCountMap.put(type, furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return new HashMap<>(Collections.unmodifiableMap(furnitureItemsCountMap));
    }

    public float getTotalOrderCost() {
        float result = 0;
        for(Map.Entry<Furniture, Integer> e : furnitureItemsCountMap.entrySet()) {
            result = result + e.getKey().cost()*e.getValue();
        }
        return result;
    }

    public int getTypeCount(Furniture type) {
        return furnitureItemsCountMap.getOrDefault(type, 0);
    }

    public float getTypeCost(Furniture type) {
        final int count = furnitureItemsCountMap.getOrDefault(type, 0);
        return type.cost() * count;
    }

    public int getTotalOrderQuantity() {
        int result = 0;
        for(Map.Entry<Furniture, Integer> e : furnitureItemsCountMap.entrySet()) {
            result = result + e.getValue();
        }
        return result;
    }
}
