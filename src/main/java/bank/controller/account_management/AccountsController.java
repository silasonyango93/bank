package bank.controller.account_management;

import bank.dto.account_management.AccountBalanceResponseDto;
import bank.dto.account_management.AccountCreationRequestDto;
import bank.dto.account_management.AccountCreditRequestDto;
import bank.dto.account_management.TransferRequestDto;
import bank.dto.user_management.AuthenticationObject;
import bank.entity.account_management.AccountsEntity;
import bank.entity.user_management.User;
import bank.repository.account_management.AccountsRepository;
import bank.repository.user_management.UserRepository;
import bank.security.JwtTokenProvider;
import bank.service.account_management.AccountService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/account")
@Api(tags = "accounts")
public class AccountsController {
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/balance/{accountNumber}")
    @ApiOperation(value = "${AccountsController.balance}", response = AccountBalanceResponseDto.class, authorizations = {@Authorization(value = "apiKey")})
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public void retrieveAccountBalance(@ApiParam("accountNumber") @PathVariable String accountNumber) {

    }


    @PostMapping("/create")
    @ApiOperation(value = "${AccountsController.create}", response = AccountsEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 422, message = "Account number already exists")})
    public ResponseEntity<AccountsEntity> createAccount(HttpServletRequest httpServletRequest, @ApiParam("Account details") @RequestBody AccountCreationRequestDto accountCreationRequestDto) {
        String accessToken = jwtTokenProvider.resolveToken(httpServletRequest);
        String email = jwtTokenProvider.getUsername(accessToken);
        User currentUser = userRepository.findByUserEmail(email);

        AccountsEntity createdAccount = accountService.createAccount(currentUser.getUserId(),accountCreationRequestDto);
        if (createdAccount == null) {
            return new ResponseEntity<AccountsEntity>(createdAccount, HttpStatus.valueOf(500));
        }
        return new ResponseEntity<AccountsEntity>(createdAccount, HttpStatus.valueOf(200));
    }

    @PostMapping("/credit")
    @ApiOperation(value = "${AccountsController.credit}", response = AccountBalanceResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 422, message = "Account number does not exist")})
    public void creditAccount(@ApiParam("Account details") @RequestBody AccountCreditRequestDto accountCreditRequestDto) {

    }

    @PostMapping("/debit")
    @ApiOperation(value = "${AccountsController.debit}", response = AccountBalanceResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 422, message = "Account number does not exist"),
            @ApiResponse(code = 423, message = "Insufficient funds")
    })
    public void debitAccount(@ApiParam("Account details") @RequestBody AccountCreditRequestDto accountCreditRequestDto) {

    }

    @PostMapping("/transfer")
    @ApiOperation(value = "${AccountsController.transfer}", response = AccountBalanceResponseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 420, message = "Account to be debited does not exist"),
            @ApiResponse(code = 421, message = "Account to be credited does not exist")
    })
    public void transfer(@ApiParam("Transfer details") @RequestBody TransferRequestDto transferRequestDto) {

    }
}
