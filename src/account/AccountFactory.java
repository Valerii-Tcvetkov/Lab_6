package account;

import client.Client;

public class AccountFactory {

    private Client client;
    private Double creditLimit;
    private Double creditCommission;
    private Double interestRate;
    private boolean validClient;


    public AccountFactory(Client client, Double creditLimit, Double commission, Double interestRate) {
        validClient = true;
        if (client.getPassport() == 0 || client.getAddress() == null) validClient = false;
        this.client = client;
        this.creditLimit = creditLimit;
        this.creditCommission = commission;
        this.interestRate = interestRate;
    }

    public AccountFactory setClient(Client client) {
        this.client = client;
        validClient = true;
        if (client.getPassport() == 0 || client.getAddress() == null) validClient = false;
        return this;
    }

    public Account createCreditAccount() {
        if (validClient) return new CreditAccount(client, creditLimit, creditCommission);
        return new UnverifiedAccount(new CreditAccount(client, creditLimit, creditCommission));
    }

    public Account createDebitAccount() {
        if (validClient) return new DebitAccount(client, interestRate);
        return new UnverifiedAccount(new DebitAccount(client, interestRate));
    }

    public Account createDepositAccount(Integer timeLimit, Double startMoney) {
        if (validClient) return new DepositAccount(client, timeLimit, startMoney);
        return new UnverifiedAccount(new DepositAccount(client, timeLimit, startMoney));
    }
}
