package design_patterns.facade;

import java.util.List;

public class TestBankAccount {
    public static void main(String[] args) {
       BankAccountFacade accessing = new BankAccountFacade( 324324, 435);
       accessing.makeWithdraw(100);
       accessing.makeDeposit(200);
    }
}

interface BalanceOperation{
    void process(double cashToGet);
}

class WithdrawCashOperation implements BalanceOperation{
    private double cashInAccount;
    private final BalanceAwareService balanceAwareService;

    WithdrawCashOperation(BalanceAwareService balanceAwareService) {
        this.balanceAwareService = balanceAwareService;
        this.cashInAccount = balanceAwareService.getCashInAccount();
    }


    @Override
    public void process(double cashToGet) {
        System.out.println("WithdrawCashOperation");
    }

    public void makeWithdraw(double cashToDeposit){
        decreaseCashInAccount(cashToDeposit);
        System.out.println("Withdraw complete: Current balance is " + balanceAwareService.getCashInAccount());

    }
    public void decreaseCashInAccount(double cashWithdraw){
        cashInAccount -= cashWithdraw;
        balanceAwareService.setCashInAccount(cashInAccount);
        System.out.println("Withdraw complete: Current balance is " + balanceAwareService.getCashInAccount());

    }

}

class DepositCashOperation implements BalanceOperation{

    private final BalanceAwareService balanceAwareService;
    private double cashInAccount;
    public DepositCashOperation(BalanceAwareService balanceAwareService) {
        this.balanceAwareService = balanceAwareService;
        this.cashInAccount= balanceAwareService.getCashInAccount();
    }

    @Override
    public void process(double cashToGet) {
        System.out.println("DepositCashOperation");
    }


    public void increaseCashInAccount(double cashDeposited){
        cashInAccount += cashDeposited;
        balanceAwareService.setCashInAccount(cashInAccount);
    }

    public void makeDeposit(double cashToDeposit){
        increaseCashInAccount(cashToDeposit);
        System.out.println("Withdraw complete: Current balance is " + balanceAwareService.getCashInAccount());

    }

}

interface AccountValidation{
    void validate(int accountNumber, int securityCode, double cashToGet);
}

class BankAccountFacade {
    List<AccountValidation> accountValidation = List.of(
            new FundsCheck(new BalanceAwareService()),   new SecurityCodeCheck(), new AccountNumberCheck());
    WelcomeToBank welcomeToBank;

    private int accountNumber;
    private int securityCode;
    private BalanceAwareService balanceAwareService = new BalanceAwareService();

    public BankAccountFacade(int accountNumber, int securityCode) {
        this.accountNumber = accountNumber;
        this.securityCode = securityCode;
    }

    public void doBalanceOperation(BalanceOperation balanceOperation, double cashToGet){
        accountValidation.forEach(validatedAccount -> validatedAccount.validate(accountNumber, securityCode, cashToGet));
        balanceOperation.process(cashToGet);
    }

    public void makeWithdraw(int cashToGet) {
        var balanceOperation = new WithdrawCashOperation(balanceAwareService);
        balanceOperation.makeWithdraw(cashToGet);
        doBalanceOperation(balanceOperation, cashToGet);
    }

    public void makeDeposit(int cashToGet) {
        var balanceOperation = new DepositCashOperation(balanceAwareService);
        balanceOperation.makeDeposit(cashToGet);
        doBalanceOperation(balanceOperation, cashToGet);
    }
}


class BalanceAwareService {
    private double cashInAccount = 1000.00;
    public double getCashInAccount() {
        return cashInAccount;
    }

    public void setCashInAccount(double cashInAccount) {
        this.cashInAccount = cashInAccount;
    }
}

class FundsCheck implements AccountValidation{

    private final BalanceAwareService balanceAwareService;

    FundsCheck(BalanceAwareService balanceAwareService) {
        this.balanceAwareService = balanceAwareService;
    }


    public boolean haveEnoughMoney(double cashToWithdraw){
        if (cashToWithdraw > balanceAwareService.getCashInAccount()){
            System.out.println("Not enough money");
            System.out.println("Current balance: " + balanceAwareService.getCashInAccount());
            return false;
        } else {

            return true;
        }
    }



    @Override
    public void validate(int accountNumber, int securityCode, double cashToGet) {
        if (this.haveEnoughMoney(cashToGet)){
            System.out.println("Transaction complete");
        }else {
            System.out.println("Transaction Failed");

        }
    }
}

class SecurityCodeCheck implements AccountValidation{
    private int securityCode = 435;

    public int getSecurityCode() {
        return securityCode;
    }

    public boolean isCodeCorrect(int secCodeToCheck){
        return secCodeToCheck == getSecurityCode();
    }


    @Override
    public void validate(int accountNumber, int securityCode, double cashToGet) {
        if (this.isCodeCorrect(getSecurityCode())){
            System.out.println("Transaction complete");
        }else {
            System.out.println("Transaction Failed");

        }
    }
}

class AccountNumberCheck implements AccountValidation{

    private int accountNumber = 324324;

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean accountActive(int acctNumToCheck){
        return acctNumToCheck == getAccountNumber();
    }

    @Override
    public void validate(int accountNumber, int securityCode, double cashToGet) {
        if (this.accountActive(getAccountNumber())){
            System.out.println("Transaction complete");
        }else {
            System.out.println("Transaction Failed");

        }
    }
}

class WelcomeToBank{

    public void welcomeToBank(){
        System.out.println("Welcome to ABC bank");
    }
}

