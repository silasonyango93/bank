package bank.service.account_management;

import bank.dto.account_management.AccountStatusResponseDto;
import bank.dto.account_management.AccountCreationRequestDto;
import bank.entity.account_management.AccountStatus;
import bank.entity.account_management.AccountsEntity;
import bank.entity.transaction_management.TransactionsEntity;
import bank.repository.account_management.AccountsRepository;
import bank.repository.transaction_management.TransactionTypesRepository;
import bank.repository.transaction_management.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    TransactionTypesRepository transactionTypesRepository;

    public AccountsEntity createAccount(int userId, AccountCreationRequestDto accountCreationRequestDto) {
        return accountsRepository.save(new AccountsEntity(
                userId,
                accountCreationRequestDto.getAccountName(),
                accountCreationRequestDto.getAccountNumber(),
                0.0,
                0
        ));
    }

    public AccountStatusResponseDto creditAnAccount(String accountNumber, double amount) {
        AccountsEntity accountToBeCredited = accountsRepository.findByAccountNumber(accountNumber);

        if (accountToBeCredited == null) {
            return new AccountStatusResponseDto(
                    0,
                    null,
                    0.0,
                    false,
                    AccountStatus.DOES_NOT_EXIST
            );
        }

        if (accountToBeCredited.getIsTransactionOnGoing() == 1) {
            return new AccountStatusResponseDto(
                    accountToBeCredited.getAccountId(),
                    accountToBeCredited.getAccountName(),
                    accountToBeCredited.getAccountBalance(),
                    true,
                    AccountStatus.ONGOING_TRANSACTION
            );
        }

        accountToBeCredited.setIsTransactionOnGoing(1);
        accountsRepository.save(accountToBeCredited);
        accountToBeCredited.setAccountBalance(accountToBeCredited.getAccountBalance() + amount);
        accountToBeCredited.setIsTransactionOnGoing(0);
        AccountsEntity updatedAccount = accountsRepository.save(accountToBeCredited);

        transactionsRepository.save(new TransactionsEntity(
                transactionTypesRepository.findByTransactionTypeCode(1).getTransactionTypeId(),
                updatedAccount.getAccountId(),
                accountToBeCredited.getAccountBalance(),
                updatedAccount.getAccountBalance(),
                updatedAccount.getAccountNumber(),
                null
        ));
        return new AccountStatusResponseDto(
                updatedAccount.getAccountId(),
                updatedAccount.getAccountName(),
                updatedAccount.getAccountBalance(),
                false,
                AccountStatus.SUCCESSFUL_TRANSACTION
        );
    }
}
