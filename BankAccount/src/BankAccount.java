public class BankAccount
{
    public static final double BONUS = 0.03;
    
    private static double totalDeposit = 0;
    private static int accountsOpened = 0;
    
    private double balance;
    private String name;
    
    public BankAccount()
    {
        this(0.0, "");
    }
    
    public BankAccount(double balanceIn, String nameIn)
    {
        accountsOpened++;
        balance = balanceIn + (balanceIn * BONUS);
        totalDeposit += balanceIn;
        name = nameIn;
    }
    
    public void addMoney(double amtIn)
    {
        balance += amtIn;
        totalDeposit += amtIn;
    }
    
    public void subMoney(double amtOut)
    {
        if(balance - amtOut > 0)
        {
            balance -= amtOut;
        }
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    public static double getDeposited()
    {
        return totalDeposit;
    }
    
    public static int getOpened()
    {
        return accountsOpened;
    }
    
    public static double getAverageInit()
    {
        return (totalDeposit/accountsOpened);
    }
}