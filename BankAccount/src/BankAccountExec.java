public class BankAccountExec
{
    public static void main(String[] args)
    {
        BankAccount newAcct = new BankAccount(100, "Mark");
        BankAccount nextAcct = new BankAccount(12.0, "Joe");
        BankAccount lastAcct = new BankAccount(500.0, "Rob");
        
        nextAcct.addMoney(13.0);
        nextAcct.addMoney(25.0);
        
        System.out.println("Mark balance: " + newAcct.getBalance());
        System.out.println("Joe balance: " + nextAcct.getBalance());
        System.out.println("Rob balance: " + lastAcct.getBalance());
        System.out.println("Total deposited: " + BankAccount.getDeposited());
        System.out.println("Accounts opened today: " + BankAccount.getOpened());
        System.out.println("Average initial account deposit: " + BankAccount.getAverageInit());
    }
}