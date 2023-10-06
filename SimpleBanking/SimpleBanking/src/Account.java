import java.util.ArrayList;

public class Account {

    /**
     * Account name.
     */
    private String name;

    /**
     * Account number.
     */
    private String uuid;

    /**
     * Primary user on account.
     */
    private User primary;

    /**
     * List of transactions on account.
     */
    private ArrayList<Transaction> transactions;

    public Account(String name, User primary, Bank theBank) {

        // set the account name and primary
        this.name = name;
        this.primary = primary;

        // generate uuid for account
        this.uuid = theBank.getNewAccountUUID();

        // init transactions
        this.transactions = new ArrayList<Transaction>();

    }

    public String getUUID() {
        return this.uuid;
    }

    public String getSummaryLine() {

        double balance = this.getBalance();

        if (balance >= 0) {
            return String.format("%s : %s : $%.02f", this.uuid, this.name, balance);
        } else {
            return String.format("%s : %s : $(%.02f)", this.uuid, this.name, balance);
        }

    }

    public double getBalance() {
        double balance = 0;
        for (Transaction t : this.transactions) {
            balance += t.getAmount();
        }
        return balance;
    }

    public void printTransHistory() {

        System.out.printf("\nTransaction history for account %s\n", this.uuid);
        for (int t = this.transactions.size()-1; t >= 0; t--) {
            System.out.printf(this.transactions.get(t).getSummaryLine());
        }

        System.out.println();
    }

    public void addTransaction(double amount, String memo) {

        Transaction newTrans = new Transaction(amount, memo, this);
        this.transactions.add(newTrans);

    }
}
