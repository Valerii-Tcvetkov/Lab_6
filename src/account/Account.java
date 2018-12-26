package account;

import account.account_parameters.Withdraw;
import client.Client;

public abstract class Account{
    Double interestRate = 0.0;
    Withdraw withdraw = Withdraw.NON_WITHDRAW;
    Double creditCommission = 0.0;
    Integer timeLimit = 0;
    Double creditLimit = 0.0;
    Double balance = 0.0;
    Client client;

    Account(Client client){
        this.client = client;
    }

    public abstract void addMoney(Double money);
    public abstract Double getMoney(Double money);
    public abstract void sendMoneyToAccount(Double money, Account account);

    public Double getBalance() {
        return this.balance;
    }

    public Double getCreditCommission(){
        return this.creditCommission;
    }

    public Double getInterestRate() {
        return interestRate;
    }
}
