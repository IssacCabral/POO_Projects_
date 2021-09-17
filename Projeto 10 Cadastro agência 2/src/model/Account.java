package model;

public abstract class Account {
    protected float balance;
    protected String clientId;
    protected static int idAccount = 0;
    protected int id;
    protected String type;

    public Account(String clientId, String type){
        this.clientId = clientId;
        this.type = type;
        this.id = Account.idAccount++;
    }

    protected void checkValue(float value){
        if(value <= 0){
            throw new RuntimeException("Fail: valor R$" + value + " inválido!");
        }
    }

    protected void checkValueTransfer(float value){
        checkValue(value);
        if(value > this.balance){
            throw new RuntimeException("Fail: Valor R$" + value + " maior que o seu balance de R$" + balance);
        }
    }

    public void deposit(float value){
        checkValue(value);
        this.balance += value;
    }

    public abstract void monthlyUpdate();

    public void transfer(Account other, float value){
        checkValueTransfer(value);
        other.deposit(value);
        this.balance -= value;
    }

    public void withdraw(float value){
        checkValueTransfer(value);
        this.balance -= value;
    }

    // Getters and Setters
    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public static int getIdAccount() {
        return idAccount;
    }

    public static void setIdAccount(int idAccount) {
        Account.idAccount = idAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString(){
        return this.id + ":" + this.clientId + ":" + this.balance + ":" + this.type;
    }
}
