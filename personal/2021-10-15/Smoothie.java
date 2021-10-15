import java.util.*;
import static java.util.stream.Collectors.*;

class Smoothie {
    public static String ingredients(String order) {
        final List<String> stringList = Arrays.asList(order.split(","));
        System.out.println("stringList = " + stringList);
        final SmoothieOption smoothieOption = stringList.stream()
          .findFirst()
          .map(s -> SmoothieOption.getSmoothieOption(s))
          .orElse(null);
        //System.out.println(smoothieOption);
      
        if (stringList.size() > 1) {
          final List<InputIngedient> inputIngedientList = new ArrayList<>();
          for (int i=1; i<stringList.size(); i++) {
            inputIngedientList.add(convert(stringList.get(i)));
          }
          //System.out.println(inputIngedientList);
          return prepareResult(smoothieOption, inputIngedientList);
        }
        return prepareResult(smoothieOption);
    }
  
  private static String prepareResult(final SmoothieOption smoothieOption, final List<InputIngedient> inputIngedientList) {
    
    return smoothieOption.ingredients.stream()
          .map(e -> e.getName())
          .sorted()
          .collect(joining(","));
  }
  
  private static String prepareResult(final SmoothieOption smoothieOption) {
    return smoothieOption.ingredients.stream()
          .map(e -> e.getName())
          .sorted()
          .collect(joining(","));
  }
  
    private static InputIngedient convert(String stringValue) {
      if (stringValue.charAt(0) == '-') {
        return new InputIngedient(true, stringValue.substring(1));
      } else {
        return new InputIngedient(stringValue);
      }
    }
}

enum Ingedient {
  STRAWBERRY, 
  BANANA, 
  PINEAPPLE, 
  MANGO, 
  PEACH,
  HONEY,
  BLACKBERRY,
  BLUEBERRY,
  BLACK_CURRANT,
  GRAPE_JUICE,
  FROZEN_YOGURT,
  GREEN_APPLE,
  LIME,
  AVOCADO,
  SPINACH,
  ICE,
  APPLE_JUICE,
  ICE_CREAM,
  CHOCOLATE,
  PEANUT,
  CHERRY;
  
  public String getName() {
    return this.name().replaceAll("_", " ").toLowerCase();
  }
}

enum SmoothieOption {
  CLASSIC("Classic", new HashSet<Ingedient>(Arrays.asList(Ingedient.STRAWBERRY, Ingedient.BANANA, Ingedient.PINEAPPLE, Ingedient.MANGO, Ingedient.PEACH, Ingedient.HONEY))),
  FREEZIE("Freezie", new HashSet<Ingedient>(Arrays.asList(Ingedient.BLACKBERRY))),
  GREENIE("Greenie", new HashSet<Ingedient>(Arrays.asList(Ingedient.GREEN_APPLE))),
  JUST_DESSERTS("Just Desserts", new HashSet<Ingedient>(Arrays.asList(Ingedient.BANANA)));
  
  public final String name;
  public final Set<Ingedient> ingredients;
  
  SmoothieOption(final String name, final Set<Ingedient> ingredients) {
    this.name = name;
    this.ingredients = ingredients;
  }
  
  public static SmoothieOption getSmoothieOption(String value) {
    for (SmoothieOption s: SmoothieOption.values()) {
      if (s.name().replaceAll("_", " ").toLowerCase().equals(value.toLowerCase())) {
        return s;
      }
    }
    return null;
  }
}

class InputIngedient {
  
  private boolean isRestricted;
  
  private String name;
  
  InputIngedient(final boolean isRestricted, final String name) {
    this.isRestricted = isRestricted;
    this.name = name;
  }
  
  InputIngedient(final String name) {
    this.name = name;
  }
  
  public boolean isRestricted() {
    return isRestricted;
  }
  
  public String getName() {
    return name;
  }
  
  public String toString() {
    return "InputIngedient { isRestricted " + isRestricted + ", name = " + name + "}"; 
  }
}
