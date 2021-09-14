package models;
import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String prefixe;
    private List<Fone> fones;
    private String name;

    public Contact(String name){
        this.name = name;
        this.fones = new ArrayList<>();
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public List<Fone> getFones() {return fones;}

    //Methods
    public void addFone(Fone fone) throws Exception{
        if(!Fone.validateNumber(fone.getNumber())){
            throw new Exception("Fone inválido papitoo!!");
        }
        fones.add(fone);
    }

    public void rmFone(int index) throws Exception{
        if(!fones.contains(fones.get(index))){
            throw new Exception("Índice não encontrado!");
        }
        fones.remove(index);
    }

    public String toString(){
        int i = 0;
        String aux = this.name + "- ";

        for(int j = 0; j < fones.size(); j++){
            aux += "[" + i + ":" + fones.get(j) + "]";
            i++;
        }
        return aux;
    }
}
