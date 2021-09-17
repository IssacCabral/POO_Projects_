package model;

public class CheckingAccount extends Account{

    public CheckingAccount(String clientId, String type) {
        super(clientId, type);
    }

    @Override
    public void monthlyUpdate(){
        this.balance -= 20;
    }
}
