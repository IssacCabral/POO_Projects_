package model;

public class Setor {
    private String nome;
    private double preco;
    private int qtd = 0;
    private int capacidade;

    public Setor(String nome, double preco, int capacidade){
        this.nome = nome;
        this.preco = preco;
        this.capacidade = capacidade;
    }

    // Getters and Setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void vender(){
        if(this.qtd == this.capacidade){
            throw new RuntimeException("Fail: já está com capacidade máxima");
        }
        this.qtd +=1;
    }

    public String toString(){
        return "[" + this.nome + ":" + this.preco + ":" + this.qtd + "/" + this.capacidade + "]";
    }
}
