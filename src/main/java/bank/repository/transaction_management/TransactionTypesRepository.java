package bank.repository.transaction_management;

import bank.entity.transaction_management.TransactionTypesEntity;
import bank.entity.user_management.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypesRepository extends JpaRepository<TransactionTypesEntity, Long> {
}
