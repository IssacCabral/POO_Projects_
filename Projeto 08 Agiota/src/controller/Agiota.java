package controller;

import model.Client;
import model.Transaction;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Agiota {
    private int balance;
    private int nextTrid = 0;
    private Map<String, Client> repClient;
    private ArrayList<Transaction> repTransaction;

    public Agiota(int balance){
        this.balance = balance;
        this.repClient = new TreeMap<>();
        this.repTransaction = new ArrayList<>();
    }

    public String toString(){
        String aux = "";

        aux += "clients:\n";
        for(String key: this.repClient.keySet()){
            aux += "- " + this.repClient.get(key) + "\n";
        }
        aux += "transactions:\n";
        for(Transaction transaction: this.repTransaction){
            aux += "- " + transaction + "\n";
        }
        aux += "balance: " + this.balance;

        return aux;
    }

    // private Methods
    private boolean checkClient(String codeName){
        if(this.repClient.containsKey(codeName)){
            return true;
        }
        return false;
    }

    private void checkIfLends(String codeName, int value) throws Exception{
        if(this.balance < value){
            throw new Exception("Fail: value greater than the balance");
        }
        if (!this.checkClient(codeName)) {
            throw new Exception("Fail: client " + codeName + " not exists");
        }
        if (value <= 0) {
            throw new Exception("Fail: invalid value");
        }
        if (this.repClient.get(codeName).getBalance() + value > this.repClient.get(codeName).getLimite()) {
            throw new Exception("Fail: value unavailable to lend");
        }

    }

    // main methods
    public void addClient(String codeName,int limite) throws Exception{
        if(checkClient(codeName)){
            throw new Exception("Fail: client " + codeName + " already exists");
        }
        if(limite <= 0){
            throw new Exception("Fail: invalid Limite");
        }

        Client client = new Client(codeName, limite);
        this.repClient.put(codeName, client);
    }

    public Client getClient(String codeName) throws Exception{
        if(!this.checkClient(codeName)){
            throw new Exception("Fail: client" + codeName + " not exists");
        }
        return this.repClient.get(codeName);
    }

    public void lends(String codeName, int value){
        try{
            this.checkIfLends(codeName, value);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }

        int auxBalance = repClient.get(codeName).getBalance() + value;
        this.repClient.get(codeName).setBalance(auxBalance);
        this.balance -= value;

        Transaction transaction = new Transaction(this.nextTrid, codeName, value);
        this.repTransaction.add(transaction);
        this.nextTrid++;
    }

    public void receive(String codeName, int value) throws Exception{
        if(!this.checkClient(codeName)){
            throw new Exception("Fail: client not exists");
        }
        if(value > this.repClient.get(codeName).getBalance()){
            throw new Exception("Fail: valor maior que a dívida");
        }

        int auxBalance = this.repClient.get(codeName).getBalance();
        auxBalance -= value;
        this.repClient.get(codeName).setBalance(auxBalance);

        Transaction transaction = new Transaction(this.nextTrid, codeName, value*(-1));
        this.repTransaction.add(transaction);
        this.nextTrid++;

        this.balance += value;
    }

    public void kill(String codeName) throws Exception{
        if(!this.checkClient(codeName)){
            throw new Exception("Fail: client " + codeName + " not exists");
        }
        this.repClient.remove(codeName);

        ArrayList<Transaction> transactions = new ArrayList<>();
        for(int i = 0; i < this.repTransaction.size(); i++){
            if (this.repTransaction.get(i).getCodeName().equals(codeName)){
                Transaction transaction = this.repTransaction.get(i);
                transactions.add(transaction);
            }
        }

        for(Transaction transaction: transactions){
            this.repTransaction.remove(transaction);
        }

    }
}
