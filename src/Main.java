import account.Account;
import account.AccountFactory;
import account.QueryHandler;
import client.Client;

public class Main {
    public static void main(String[] args) {
        Client client = Client.newBuilder().setName("Valerii").setSurname("Tsvetkov").build();

        AccountFactory accountFactory = new AccountFactory(client, -2000.0, 100.0, 0.05);
        Account credit = accountFactory.createCreditAccount();
        Account debit = accountFactory.createDebitAccount();
        QueryHandler queryHandler = new QueryHandler();
        credit.getMoney(10.0);
        System.out.println(credit.getBalance());
        System.out.println(queryHandler.getCommission(credit));
        System.out.println(credit.getBalance());

        System.out.println();
        System.out.println();
        debit.addMoney(1000.0);
        System.out.println(debit.getBalance());
        System.out.println(debit.getInterestRate());
        queryHandler.interestPayment(debit);
        System.out.println(debit.getBalance());
        queryHandler.interestPayment(credit);


//        AccountFactory accountFactory = new AccountFactory(client, -1000.0, 0.05, 0.03);
//        Account credit = accountFactory.createCreditAccount();
//        System.out.println(credit.getClass());
//        Client client1 = Client.newBuilder().setName("Ivan").setSurname("Ivanov").setAddress("SPb").setPassport(123).build();
//        accountFactory.setClient(client1);
//        Account creditTemp = accountFactory.createCreditAccount();
//        creditTemp.addMoney(3000.0);
//        creditTemp.getMoney(3100.0);
//        System.out.println(creditTemp.getBalance());


//        AccountFactory accountFactory = new AccountFactory(client, -1000.0, 0.05);
//        Account account = accountFactory.createCreditAccount();
//        Account deposit = accountFactory.createDepositAccount(5, 300.0);
//        System.out.println(deposit.getBalance());
//        account.addMoney(1000.0);
//        account.sendMoneyToAccount(200.0, deposit);
//        System.out.println(deposit.getBalance());
//        System.out.println(account.getBalance());
//        deposit.getMoney(100.0);
    }
}
