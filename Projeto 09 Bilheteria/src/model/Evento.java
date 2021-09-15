package model;

import java.util.Map;
import java.util.TreeMap;

public class Evento {
    private String nome;
    private Map<String, Setor> repSetores;

    public Evento(String nome){
        this.nome = nome;
        this.repSetores = new TreeMap<>();
    }

    public void addSetor(Setor setor){
        if(this.repSetores.containsKey(setor.getNome())){
            throw new RuntimeException("Erro: O setor já existe");
        }
        repSetores.put(setor.getNome(), setor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Setor> getRepSetores() {
        return repSetores;
    }

    public void setRepSetores(Map<String, Setor> repSetores) {
        this.repSetores = repSetores;
    }

    public String toString(){
        String aux = "";

        aux += this.nome + "\n";

        for(String key: this.repSetores.keySet()){
            aux += "- " + this.repSetores.get(key) + "\n";
        }
        return aux;
    }
}
