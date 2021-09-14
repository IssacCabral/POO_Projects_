public class Conta {
    //Attributes
    private int accountNumber;
    private Financas financas;

    public Conta(int accountNumber){
        this.accountNumber = accountNumber;
        this.financas = new Financas();
    }

    public boolean sacar(int value){
        if(value < 0 || value > financas.getSaldo())
            return false;
        financas.
        return true;
    }

    public boolean tarifar(int value){
        return false;
    }

    public boolean extornar(int indice){
        return false;
    }

    public boolean creditar(Label label, int value){
        return false;
    }

    public String toString(){
        return "Conta:" + this.accountNumber + " " + "saldo:" + this.financas.getSaldo();
    }
}
