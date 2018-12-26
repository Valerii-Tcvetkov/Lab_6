package account;

public class UnverifiedAccount extends Account {

    Account account;
    private Double maxAmount = 3000.0;

    UnverifiedAccount(Account account){
        super(account.client);
        this.account = account;
    }

    @Override
    public void addMoney(Double money) {
        account.addMoney(money);
    }

    @Override
    public Double getMoney(Double money) {
        if (money > maxAmount) throw new IllegalArgumentException("You can't use more than " + maxAmount + " RUB");
        return account.getMoney(money);
    }

    @Override
    public void sendMoneyToAccount(Double money, Account account) {
        if (money > maxAmount) throw new IllegalArgumentException("You can't use more than " + maxAmount + " RUB");
        account.sendMoneyToAccount(money, account);
    }

    @Override
    public Double getBalance() {
        return account.getBalance();
    }

    @Override
    public Double getInterestRate() {
        return account.getInterestRate();
    }
}
