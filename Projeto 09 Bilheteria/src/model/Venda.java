package model;

public class Venda {
    private Pessoa cliente;
    private Evento evento;
    private Setor setor;
    private double valor;

    public Venda(Pessoa cliente, Evento evento, Setor setor, double valor){
        this.cliente = cliente;
        this.evento = evento;
        this.setor = setor;
        this.valor = valor;
    }

    public String toString(){
        String aux = "";

        aux += "[" + cliente.getNome() + ", " + evento.getNome() + ", " + setor.getNome() + "]";
        return aux;
    }
}
