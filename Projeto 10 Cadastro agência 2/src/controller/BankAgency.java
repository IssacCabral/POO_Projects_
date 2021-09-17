package controller;

import model.*;
import java.util.Map;
import java.util.TreeMap;

public class BankAgency {
    private Map<Integer, Account> accounts;
    private Map<String, Client> clients;

    public BankAgency(){
        this.accounts = new TreeMap<>();
        this.clients = new TreeMap<>();
    }

    private void checkAccount(int idAccount){
        if(!this.accounts.containsKey(idAccount)){
            throw new RuntimeException("Fail: Essa conta com o id " + idAccount + " não existe");
        }
    }

    public void addClient(String clientId){
        if(this.clients.containsKey(clientId)){
            throw new RuntimeException("Fail: o client " + clientId + " já existe");
        }
        Client client = new Client(clientId);

        CheckingAccount cc = new CheckingAccount(clientId, "CC");
        SavingsAccount cp = new SavingsAccount(clientId, "CP");

        client.getAccounts().add(cc);
        client.getAccounts().add(cp);

        this.accounts.put(cc.getId(), cc);
        this.accounts.put(cp.getId(), cp);

        this.clients.put(clientId, client);
    }

    public void deposit(int idAccount, float value){
        this.checkAccount(idAccount);
        this.accounts.get(idAccount).deposit(value);
    }

    public void monthlyUpdate(){
        for(Integer key: this.accounts.keySet()){
            this.accounts.get(key).monthlyUpdate();
        }
    }

    public void transfer(int deConta, int paraConta, float value){
        this.checkAccount(deConta);
        this.checkAccount(paraConta);

        this.accounts.get(deConta).transfer(accounts.get(paraConta), value);
    }

    public void withdraw(int idConta, float value){
        this.checkAccount(idConta);
        this.accounts.get(idConta).withdraw(value);
    }

    public String toString(){
        String aux = "";

        aux += "Clients:\n";

        for(String key: this.clients.keySet()){
            Client client = this.clients.get(key);
            Account account1 = client.getAccounts().get(0);
            Account account2 = client.getAccounts().get(1);

            aux += "- " + client.getClientId() + " [" + account1.getId() +
                    ", " + account2.getId() + "]\n";
        }

        aux += "Accounts:\n";

        for(String key: this.clients.keySet()){
            for(Account account: this.clients.get(key).getAccounts()){
                aux += account + "\n";
            }
        }

        return aux;
    }
}
