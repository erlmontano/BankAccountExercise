package exercise;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Transaction.
 */

public class Transaction {
  private String type;
  private double okane;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getAmount() {
    return okane;
  }

  public void setAmount(double amount) {
    this.okane = amount;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  private LocalDateTime timestamp;

  /**
 * Transaction.
*/

  public Transaction(String type, double amount) {
    this.type = type;
    this.okane = amount;
    this.timestamp = LocalDateTime.now();
  }

  @Override
    public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    return String.format("Transaction [type= %s amount= %.3f time_stamp= %s] %n",
                type, okane, timestamp.format(formatter));
  }

}
