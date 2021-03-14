package bank.repository.account_management;

import bank.entity.account_management.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<AccountsEntity, Long> {
}
