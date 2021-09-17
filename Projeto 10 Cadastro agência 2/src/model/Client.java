package model;

import java.util.List;
import java.util.ArrayList;

public class Client {
    private List<Account> accounts;
    private String clientId;

    public Client(String clientId){
        this.clientId = clientId;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
