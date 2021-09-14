import java.rmi.server.ExportException;
import java.util.ArrayList;

public class Maquina {
    private ArrayList<Espiral> espirais;
    private float saldoCliente;
    private float lucro;
    private final int maxProdutos;
    private int qtdProdAtual;
    private int qtdEspirais;

    public Maquina(int maxProdutos, int qtdEspirais) {
        this.maxProdutos = maxProdutos;
        this.qtdEspirais = qtdEspirais;

        espirais = new ArrayList<>();
        for(int i = 0; i < qtdEspirais; i++){
            this.espirais.add(new Espiral("Empty", 0, 0));
        }
    }

    public String toString(){
        String saida = "Saldo: " + this.saldoCliente + "\n";

        for(int i = 0; i < espirais.size(); i++){
            saida += i + " [    " + espirais.get(i) + "]\n";
        }
        return saida;
    }

    public boolean verificaIndex(int index){
        if(index < 0 || index >= espirais.size()){
            return false;
        }
        return true;
    }

    public void inserirDinheiro(float value) throws Exception{
        if(value < 0){
            throw new Exception("fail: Valor inválido!");
        }
        this.saldoCliente += value;
    }

    public void alterarEspiral(int index, String nome, int qtd, float preco) throws Exception{
        if(!verificaIndex(index)){
            throw new Exception("fail: índice inválido!");
        }
        if(preco < 0){
            throw new Exception("fail: preço inválido!");
        }
        if(qtd <= 0 || qtd > this.maxProdutos){
            throw new Exception("fail: qtd inválida!");
        }
        if(qtdProdAtual + qtd > this.maxProdutos){
            throw new Exception("Fail: qnt de produtos excedem o valor permitido!");
        }

        espirais.get(index).setName(nome);
        espirais.get(index).setQtd(qtd);
        espirais.get(index).setPreco(preco);
        this.qtdProdAtual += qtd;
    }

    public void limparEspiral(int index) throws Exception{
        if(!verificaIndex(index)){
            throw new Exception("fail: índice inválido!");
        }
        if(espirais.get(index).getName().equals("empty")){
            throw new Exception("fail: a espiral ja está vazia");
        }

        espirais.get(index).setName("empty");
        espirais.get(index).setQtd(0);
        espirais.get(index).setPreco(0);
        this.qtdProdAtual -= espirais.get(index).getQtd();
    }

    public void troco(){
        if(this.saldoCliente != 0){
            System.out.println("Você recebeu " + this.saldoCliente + "R$");
            this.saldoCliente = 0;
            return;
        }
        System.out.println("Você não tem nenhum saldo");
    }

    public void comprar(int index) throws Exception{
        if(!verificaIndex(index)){
            throw new Exception("fail: índice inválido!");
        }
        if(espirais.get(index).getQtd() == 0){
            throw new Exception("fail: sem produto");
        }
        if(espirais.get(index).getPreco() > this.saldoCliente){
            throw new Exception("fail: saldo insuficiente!");
        }

        this.saldoCliente -= espirais.get(index).getPreco();
        espirais.get(index).setQtd(-1);
        this.lucro += espirais.get(index).getPreco();
        System.out.println("você comprou um " + espirais.get(index).getName());
    }
}
