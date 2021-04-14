package bank.entity.account_management;

public enum AccountStatus {
    DOES_NOT_EXIST,
    ONGOING_TRANSACTION,
    INSUFFICIENT_FUNDS,
    SUCCESSFUL_TRANSACTION,
    ACCOUNT_BALANCE_REQUEST,
    EXCEED_DAILY_DEPOSIT_LIMIT,
    EXCEEDS_PER_TRANSACTION_DEPOSIT_LIMIT
}
