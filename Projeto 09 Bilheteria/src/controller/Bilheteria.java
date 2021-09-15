package controller;

import java.util.ArrayList;
import model.*;
import java.util.Map;
import java.util.TreeMap;

public class Bilheteria {
    private ArrayList<Venda> repVendas;
    private Map<String, Pessoa> repPessoas;
    private Map<String, Evento> repEventos;
    private double caixa = 0;

    public Bilheteria(){
        this.repVendas = new ArrayList<>();
        this.repPessoas = new TreeMap<>();
        this.repEventos = new TreeMap<>();
    }

    public void addPessoa(String nome, String pagaMeia){
        if(this.repPessoas.containsKey(nome)){
            throw new RuntimeException("Fail: A pessoa " + nome + " já existe");
        }
        this.repPessoas.put(nome, new Pessoa(nome,pagaMeia.equals("meia") ? true: false));
    }

    public void showPessoas(){
        String saida = "";

        for(Pessoa pessoa: this.repPessoas.values()){
            saida += pessoa + "\n";
        }
        System.out.print(saida);
    }

    public void addEvento(String idEvento){
        if(this.repEventos.containsKey(idEvento)){
            throw new RuntimeException("Fail: o evento " + idEvento + " já existe");
        }

        this.repEventos.put(idEvento, new Evento(idEvento));
    }

    public void showEventos(){
        String saida = "";

        for(Evento evento: this.repEventos.values()){
            saida += evento;
        }
        System.out.print(saida);
    }

    public void addSetor(String idEvento, String idSetor, double preco, int capacidade){
        if(!this.repEventos.containsKey(idEvento)){
            throw new RuntimeException("Fail: o evento " + idEvento + " não existe");
        }
        if(preco <= 0){
            throw new RuntimeException("Fail: valor de preco inválido");
        }
        if(capacidade <= 0){
            throw new RuntimeException("Fail: valor de capacidade inválido");
        }
        Setor setor = new Setor(idSetor, preco, capacidade);
        this.repEventos.get(idEvento).addSetor(setor);
    }

    private void checarVenda(String cliente, String idEvento, String idSetor){
        if(!this.repPessoas.containsKey(cliente)){
            throw new RuntimeException("Fail: o cliente " + cliente + " não existe");
        }
        if(!this.repEventos.containsKey(idEvento)){
            throw new RuntimeException("Fail: o evento " + idEvento + " não existe");
        }
        if(!this.repEventos.get(idEvento).getRepSetores().containsKey(idSetor)){
            throw new RuntimeException("Fail: o setor " + idSetor + " não existe");
        }
    }

    public void vender(String cliente, String evento, String setor){
        checarVenda(cliente, evento, setor);

        Pessoa pessoaAux = this.repPessoas.get(cliente);
        Evento eventoAux = this.repEventos.get(evento);
        Setor setorAux = this.repEventos.get(evento).getRepSetores().get(setor);
        Double precoVenda = pessoaAux.isPagaMeia() ? (setorAux.getPreco()/2) : setorAux.getPreco();

        Venda venda = new Venda(pessoaAux, eventoAux, setorAux, precoVenda);

        this.repVendas.add(venda);
        setorAux.vender();
        this.caixa += precoVenda;
    }

    public void showVendas(){
        String aux = "";

        for(Venda venda: this.repVendas){
            aux += venda + "\n";
        }
        aux += "R$ " + this.caixa + "\n";
        System.out.print(aux);
    }
}
