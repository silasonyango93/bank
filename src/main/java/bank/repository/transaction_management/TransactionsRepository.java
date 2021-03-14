package bank.repository.transaction_management;

import bank.entity.transaction_management.TransactionTypesEntity;
import bank.entity.transaction_management.TransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Long> {
}
