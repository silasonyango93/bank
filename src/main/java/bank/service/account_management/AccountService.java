package bank.service.account_management;

import bank.dto.account_management.AccountCreationRequestDto;
import bank.entity.account_management.AccountsEntity;
import bank.repository.account_management.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountsRepository accountsRepository;

    public AccountsEntity createAccount(int userId, AccountCreationRequestDto accountCreationRequestDto) {
        return accountsRepository.save(new AccountsEntity(
                userId,
                accountCreationRequestDto.getAccountName(),
                accountCreationRequestDto.getAccountNumber(),
                0.0,
                0
        ));
    }
}
