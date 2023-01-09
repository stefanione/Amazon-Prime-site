package fileio;

public class Inputforuser {
    private String name;

    private String password;

    private String country;

    private String accountType;

    private int balance;

    /** this method gets balance */
    public int getBalance() {
        return balance;
    }
    /** this method sets balance */
    public void setBalance(final int balance) {
        this.balance = balance;
    }
    /** this method gets name */
    public String getName() {
        return name;
    }
    /** this method sets name */
    public void setName(final String name) {
        this.name = name;
    }
    /** this method gets password */
    public String getPassword() {
        return password;
    }
    /** this method sets password */
    public void setPassword(final String password) {
        this.password = password;
    }
    /** this method gets country */
    public String getCountry() {
        return country;
    }
    /** this method sets country */
    public void setCountry(final String country) {
        this.country = country;
    }
    /** this method gets the accounttype */
    public String getAccountType() {
        return accountType;
    }
    /** this method sets the accounttype */
    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

}
