package model;

import java.util.ArrayList;

public class Contact {
    private String name;
    private ArrayList<Fone> fones;
    private boolean starred = false;

    public Contact(String name){
        this.name = name;
        this.fones = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {return name;}
    public ArrayList<Fone> getFones() {return fones;}
    public void setName(String name) {this.name = name;}
    public boolean getStarred(){return this.starred;}
    public void setStarred(boolean value){this.starred = value;}

    // Methods
    public void addFone(Fone fone) throws Exception{
        if(!Fone.validateNumber(fone.getNumber())){
            throw new Exception("Número " + fone.getNumber() + " inválido!");
        }
        fones.add(fone);
    }

    public void rmFone(int index) throws Exception{
        if(!fones.contains(fones.get(index))){
            throw new Exception("Índice não encontrado!");
        }
    }

    public String toString(){
        int i = 0;
        String aux = this.name + " ";

        for(int j = 0; j < fones.size(); j++){
            aux += "[" + i + ":" + fones.get(j) + "]";
            i++;
        }
        return aux;
    }
}
