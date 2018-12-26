package account;

public class QueryHandler {

    private Accountant accountant = new Accountant();

    public Double getCommission(Account account) {
        if (account instanceof UnverifiedAccount)
            return accountant.getCommission(((UnverifiedAccount) account).account);
        return accountant.getCommission(account);
    }

    public void interestPayment(Account account) {
        if (account.getClass().equals(UnverifiedAccount.class)) {
            accountant.givePayment(((UnverifiedAccount) account).account);
            return;
        }
        accountant.givePayment(account);
    }
}
