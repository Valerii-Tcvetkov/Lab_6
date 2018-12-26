package account;

import account.account_parameters.Withdraw;
import client.Client;

public class CreditAccount extends Account{

    public CreditAccount(Client client, Double creditLimit, Double commission) {
        super(client);
        this.creditCommission = commission;
        this.creditLimit = creditLimit;
        this.withdraw = Withdraw.WITHDRAW;
    }

    @Override
    public void addMoney(Double money) {
        this.balance += money;
    }

    @Override
    public Double getMoney(Double money) {
        if (this.balance - money > creditLimit){
            this.balance -= money;
            return money;
        } else {
            return 0.0;
        }
    }

    @Override
    public void sendMoneyToAccount(Double money, Account account) {
        account.addMoney(getMoney(money));
    }

    protected Double getCommission(){
        return getMoney(creditCommission);
    }
}
