import java.util.*;
//import java.math.BigInteger;
import java.util.Objects;

public class Transactions {

    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
      List<Transaction> transactionList = new ArrayList<>();
        for (String s : transactions) {
          String[] data = s.split(",");
          transactionList.add(convert(data));
        }
      Map<UniquelyIdentifier, List<Transaction>> map = prepareMap(transactionList);
        System.out.println(creditLimit);
      
      List<String> invalidTransactions = new ArrayList<>();
      for(Map.Entry<UniquelyIdentifier, List<Transaction>> entry : map.entrySet()) {
        invalidTransactions.addAll(findInvalidTransactionsFor(entry, creditLimit));
      }
      return invalidTransactions;
    }
  
  private static List<String> findInvalidTransactionsFor(Map.Entry<UniquelyIdentifier, List<Transaction>> entry, int creditLimit) {
    List<String> invalidTransactions = new ArrayList<>();
     int currentCreditLimit = creditLimit;
     List<Transaction> list = entry.getValue();
     for (Transaction t : list) {
          int amount = t.amount;
          currentCreditLimit = currentCreditLimit - amount;
          if (currentCreditLimit < 0) {
            invalidTransactions.add(t.transactionId);
          }
        }
    return invalidTransactions;
  }
  
  private static Map<UniquelyIdentifier, List<Transaction>> prepareMap(List<Transaction> transactionList) {
    final Map<UniquelyIdentifier, List<Transaction>> result = new HashMap<>();
    for (Transaction t : transactionList) {
      if (result.containsKey(t.uniquelyIdentifier)) {
        final List<Transaction> valueList = result.get(t.uniquelyIdentifier);
        valueList.add(t);
        result.put(t.uniquelyIdentifier, valueList);
      } else {
        List<Transaction> value = new ArrayList<>();
        value.add(t);
        result.put(t.uniquelyIdentifier, value);
      }
    }
    System.out.println(result);
    return result;
  }
  
  private static Transaction convert(String[] data) {
    final UniquelyIdentifier uniquelyIdentifier = new UniquelyIdentifier(data[0], data[1], data[2]);
    return new Transaction(
    uniquelyIdentifier,
    Integer.parseInt( data[3]),
    data[4]
    );
  }
}

class UniquelyIdentifier {
    public final String firstName;
    public final String lastName;
    public final String email;

    public UniquelyIdentifier(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniquelyIdentifier that = (UniquelyIdentifier) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }
  
  @Override
    public String toString() {
        return "UniquelyIdentifier{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class Transaction {
  public final UniquelyIdentifier uniquelyIdentifier;
  public final int amount;
  public final String transactionId;
  
  Transaction(UniquelyIdentifier uniquelyIdentifier, int amount, String transactionId) {
    this.uniquelyIdentifier = uniquelyIdentifier;
  this.amount = amount;
  this.transactionId =transactionId;
  }
    
  public String toString() {
    return "Transaction { uniquelyIdentifier " + uniquelyIdentifier + ", transactionId = " + transactionId + ", amount = "+ amount+ "}";
  }
}
