package account;

import account.account_parameters.Withdraw;
import client.Client;

public class DebitAccount extends Account {

    public DebitAccount(Client client, Double interestRate) {
        super(client);
        this.withdraw = Withdraw.WITHDRAW;
        this.interestRate = interestRate;
    }

    @Override
    public void addMoney(Double money) {
        this.balance += money;
    }

    @Override
    public Double getMoney(Double money) {
        if (balance - money < creditLimit){
            return 0.0;
        } else {
            balance -= money;
            return money;
        }
    }

    @Override
    public void sendMoneyToAccount(Double money, Account account) {
        account.addMoney(getMoney(money));
    }
}
