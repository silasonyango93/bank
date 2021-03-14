package bank.entity.transaction_management;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "account_transactions")
public class TransactionsEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountTransactionId")
    private int accountTransactionId;

    @Column(name = "TransactionTypeId")
    private int transactionTypeId;

    @Column(name = "AccountId")
    private int accountId;

    @Column(name = "PreviousAccountBalance")
    private double previousAccountBalance;

    @Column(name = "AccBalanceAfterTransaction")
    private double accBalanceAfterTransaction;

    @Column(name = "AccountToBeCredited")
    private String accountToBeCredited;

    @Column(name = "AccountToBeDebited")
    private String accountToBeDebited;


    public TransactionsEntity() {
    }

    public TransactionsEntity(int transactionTypeId, int accountId, double previousAccountBalance, double accBalanceAfterTransaction, String accountToBeCredited, String accountToBeDebited) {
        this.transactionTypeId = transactionTypeId;
        this.accountId = accountId;
        this.previousAccountBalance = previousAccountBalance;
        this.accBalanceAfterTransaction = accBalanceAfterTransaction;
        this.accountToBeCredited = accountToBeCredited;
        this.accountToBeDebited = accountToBeDebited;
    }

    public int getAccountTransactionId() {
        return accountTransactionId;
    }

    public void setAccountTransactionId(int accountTransactionId) {
        this.accountTransactionId = accountTransactionId;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getPreviousAccountBalance() {
        return previousAccountBalance;
    }

    public void setPreviousAccountBalance(double previousAccountBalance) {
        this.previousAccountBalance = previousAccountBalance;
    }

    public double getAccBalanceAfterTransaction() {
        return accBalanceAfterTransaction;
    }

    public void setAccBalanceAfterTransaction(double accBalanceAfterTransaction) {
        this.accBalanceAfterTransaction = accBalanceAfterTransaction;
    }

    public String getAccountToBeCredited() {
        return accountToBeCredited;
    }

    public void setAccountToBeCredited(String accountToBeCredited) {
        this.accountToBeCredited = accountToBeCredited;
    }

    public String getAccountToBeDebited() {
        return accountToBeDebited;
    }

    public void setAccountToBeDebited(String accountToBeDebited) {
        this.accountToBeDebited = accountToBeDebited;
    }
}
