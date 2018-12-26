package account;

import client.Client;

public class DepositAccount extends Account {

    public DepositAccount(Client client, Integer timeLimit, Double startMoney) {
        super(client);
        this.timeLimit = timeLimit;
        this.balance = startMoney;
        if (startMoney < 1000.0) {
            this.interestRate = 0.01;
        } else if (startMoney < 5000.0) {
            this.interestRate = 0.04;
        } else if (startMoney < 20000.0) {
            this.interestRate = 0.05;
        }
    }

    @Override
    public void addMoney(Double money) {
        this.balance += money;
    }

    @Override
    public Double getMoney(Double money) {
        if (timeLimit > 0) {
            System.out.println("You can't get money for " + timeLimit + " months");
            return 0.0;
        } else if (balance - money < creditLimit) {
            System.out.println("You don't have enough money");
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
