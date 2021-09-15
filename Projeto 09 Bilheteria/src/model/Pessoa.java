package model;

public class Pessoa {
    private String nome;
    private boolean pagaMeia;

    public Pessoa(String nome, boolean pagaMeia){
        this.nome = nome;
        this.pagaMeia = pagaMeia;
    }

    // Getters and Setters
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public boolean isPagaMeia() {return pagaMeia;}
    public void setPagaMeia(boolean pagaMeia) {this.pagaMeia = pagaMeia;}

    public String toString(){
        return "[" + this.nome + ", " + (this.pagaMeia? "meia" : "inteira") + "]";
    }
}
