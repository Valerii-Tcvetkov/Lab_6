package account;

public class Accountant {

    Double getCommission(Account account) {
        if (!account.getClass().equals(CreditAccount.class))
            throw new IllegalArgumentException("It's not credit account");
        if (account.balance >= 0.0) return 0.0;
        if (account.balance - account.creditCommission < account.creditLimit)
            throw new IllegalArgumentException("You should freeze this account");
        return account.getMoney(account.creditCommission);
    }

    void givePayment(Account account) {
        if (account.interestRate == 0.0) {
            System.out.println("This account don't have interest rate");
            return;
        }
        account.addMoney(account.balance * account.interestRate);
    }
}