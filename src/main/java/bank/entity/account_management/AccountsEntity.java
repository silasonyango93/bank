package bank.entity.account_management;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "account_management")
public class AccountsEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountId")
    private int accountId;

    @Column(name = "UserId")
    private int userId;

    @Column(name = "AccountName")
    private String accountName;

    @Column(name = "AccountNumber")
    private String accountNumber;

    @Column(name = "AccountBalance")
    private double accountBalance;

    @Column(name = "IsTransactionOnGoing")
    private int isTransactionOnGoing;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getIsTransactionOnGoing() {
        return isTransactionOnGoing;
    }

    public void setIsTransactionOnGoing(int isTransactionOnGoing) {
        this.isTransactionOnGoing = isTransactionOnGoing;
    }
}
