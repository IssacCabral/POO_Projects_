import java.util.List;

public class Financas {
    //Attributes
    private List<Operacao> extrato;
    private int nextId;
    private int saldo;

    //Constructor
    public Financas(){

    }

    public void addOperacao(Label label, int value){

    }

    public int getSaldo(){return this.saldo;}
    public List<Operacao> getExtrato(){return this.extrato;}
    public List<Operacao> getExtrato(int qtdOp){return this.extrato;}


}
