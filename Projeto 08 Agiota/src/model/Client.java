package model;

public class Client {
    private int balance;
    private String codeName;
    private int limite;

    public Client(String codeName, int limite){
        this.codeName = codeName;
        this.limite = limite;
    }

    public String toString(){
        return this.codeName + ":" + this.balance + "/" + this.limite;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
}
