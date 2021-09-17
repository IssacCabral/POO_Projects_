package model;

public class SavingsAccount extends Account{

    public SavingsAccount(String clientId, String type) {
        super(clientId, type);
    }

    @Override
    public void monthlyUpdate(){
        this.balance *= 1.01;
    }
}
