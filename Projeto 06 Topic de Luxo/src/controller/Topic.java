package controller;

import models.Pass;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    // Attributes
    private List<Pass> normalSeats;
    public List<Pass> prioritySeats;

    // Constructor
    public Topic(int capacity, int priority){
        normalSeats = new ArrayList<>();
        prioritySeats = new ArrayList<>();

        for(int i = 0; i < capacity - priority; i++){
            normalSeats.add(null);
        }
        for(int i = 0; i < priority; i++){
            prioritySeats.add(null);
        }
    }

    // toString()
    public String toString(){
        String aux = "[ ";

        for(Pass pass: this.prioritySeats){
            if(pass == null){
                aux += "@ ";
            }else{
                aux += "@" + pass + " ";
            }
        }

        for(Pass pass: this.normalSeats){
            if(pass == null){
                aux += "= ";
            }else{
                aux += "=" + pass + " ";
            }
        }
        aux += "]";
        return aux;
    }

    // Auxiliary Methods
    private boolean checkPass(Pass x){
        for(int i = 0; i < this.prioritySeats.size(); i++){
            if(prioritySeats.get(i) == null){
                continue;
            }
            if(x.getName().equals(this.prioritySeats.get(i).getName())){
                return false;
            }
        }
        for(int i = 0; i < this.normalSeats.size(); i++){
            if(normalSeats.get(i) == null){
                continue;
            }
            if(x.getName().equals(this.normalSeats.get(i).getName())){
                return false;
            }
        }
        return true;
    }

    private boolean checkPassByName(String name){
        for(Pass pass: this.prioritySeats){
            if(pass.getName().equals(name)){
                return true;
            }
        }
        for(Pass pass: this.normalSeats){
            if(pass.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    private boolean checkSeats(){
        if(!this.normalSeats.contains(null) && !this.prioritySeats.contains(null)){
            return false;
        }
        return true;
    }

    // insert Method
    public void in(String name, int age) throws Exception{
        Pass pass = new Pass(name, age);
        int indexPriority = this.prioritySeats.indexOf(null);
        int indexNormal = this.normalSeats.indexOf(null);

        if(!checkSeats()){
            throw new Exception("Fail: no vacancies on Topic");
        }
        if(checkPass(pass)){
            if(pass.isPriority()){
                if(indexPriority != -1){
                    this.prioritySeats.set(indexPriority, pass);
                }else{
                    if(indexNormal != -1){
                        this.normalSeats.set(indexNormal, pass);
                    }
                }
            }else{
                if(indexNormal != -1){
                    this.normalSeats.set(indexNormal, pass);
                }else{
                    if(indexPriority != -1){
                        this.prioritySeats.set(indexPriority, pass);
                    }
                }
            }
        }else{
            throw new Exception("Fail: O passageiro já está na topic");
        }
    }

    // remove method
    public void out(String name) throws Exception{
        if(checkPassByName(name)){
            for(int i = 0; i < this.prioritySeats.size(); i++){
                if(prioritySeats.get(i) == null){
                    continue;
                }
                if(prioritySeats.get(i).getName().equals(name)){
                    this.prioritySeats.set(i, null);
                }
            }
            for(int i = 0; i < this.normalSeats.size(); i++){
                if(normalSeats.get(i) == null){
                    continue;
                }
                if(normalSeats.get(i).getName().equals(name)){
                    this.normalSeats.set(i, null);
                }
            }
        }else{
            throw new Exception("Fail: Passageiro não encontrado");
        }
    }
}
