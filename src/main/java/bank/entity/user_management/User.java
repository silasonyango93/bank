package bank.entity.user_management;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "users")
public class User implements java.io.Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "UserId")
  private int userId;

  @Column(name = "Name")
  private String customerName;

  @Column(name = "UserEmail")
  private String userEmail;

  @Column(name = "EncryptedPassword")
  private String encryptedPassword;

  public User() {
  }

  public User(String customerName, String userEmail, String encryptedPassword) {
    this.customerName = customerName;
    this.userEmail = userEmail;
    this.encryptedPassword = encryptedPassword;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getEncryptedPassword() {
    return encryptedPassword;
  }

  public void setEncryptedPassword(String encryptedPassword) {
    this.encryptedPassword = encryptedPassword;
  }
}
