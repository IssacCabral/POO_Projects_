package controller;

import models.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {
    private ArrayList<Client> chairs;

    public Room(int capacity){
        this.chairs = new ArrayList<>();

        for(int i = 0; i < capacity; i++){
            chairs.add(null);
        }
    }

    public void reservar(String name, String fone, int id) throws Exception{
        if(id < 0 || id >= this.chairs.size()){
            throw new Exception("Fail: Id inválido");
        }
        if(this.chairs.get(id) != null){
            throw new Exception("Fail: A cadeira ja está ocupada");
        }
        for(Client client: chairs){
            if(client != null){
                if(client.getName().equals(name)){
                    throw new Exception("Fail: o cliente ja está no cinema");
                }
            }
        }

        Client client = new Client(name, fone);
        this.chairs.set(id, client);
    }

    public void cancelar(String name){
        for(int i = 0; i < this.chairs.size(); i++){
            if(chairs.get(i) != null){
                if(chairs.get(i).getName().equals(name)){
                    chairs.set(i, null);
                    return;
                }
            }
        }
        System.out.println("Fail: cliente não encontrado");
    }

    public ArrayList<Client> getChairs(){return this.chairs;}

    public String toString(){
        String aux = "[";

        if(this.chairs.size() == 0){
            return "[ ]";
        }

        for(int i = 0; i < this.chairs.size(); i++){
            if(this.chairs.get(i) == null){
                aux += " - ";
            }else{
                aux += this.chairs.get(i) + " ";
            }
        }
        aux += "]";
        return aux;
    }
}
