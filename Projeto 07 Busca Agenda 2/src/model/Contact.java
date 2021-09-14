package model;

import java.util.ArrayList;
import java.util.Collections;

public class Contact {
    private String name;
    private ArrayList<Fone> fones;

    public Contact(String name){
        this.name = name;
        this.fones = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {return name;}
    public ArrayList<Fone> getFones() {return fones;}
    public void setName(String name) {this.name = name;}

    // Methods
    public void addFone(Fone fone) throws Exception{
        if(!Fone.validateNumber(fone.getNumber())){
            throw new Exception("Fail: numvero inválido!");
        }
        fones.add(fone);
    }

    public void rmFone(int index) throws Exception{
        if(!fones.contains(fones.get(index))){
            throw new Exception("Fail: índice não encontrado");
        }
        fones.remove(index);
    }

    public String toString(){
        int i = 0;
        String aux = "- " + this.name + " ";

        for(int j = 0; j < fones.size(); j++){
            aux += "[" + i + ":" + fones.get(j) + "]";
            i++;
        }
        return aux;
    }
}
