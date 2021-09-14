public class Operacao {
    //Attributes
    private int indice;
    private Label label;
    private int saldo;
    private int value;

    //Constructor
    public Operacao(int indice, Label label, int value, int saldo){
        this.indice = indice;
        this.label = label;
        this.value = value;
        this.saldo = saldo;
    }

    //Getters
    public int getIndice() {
        return indice;
    }

    public Label getLabel() {
        return label;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getValue() {
        return value;
    }
    //End Getters

    public static String pad(String string, int lenght){
        return String.format("%1$" + lenght + "s", string);
    }

    public String toString(){
        return  pad("" + indice, 2)
                + ":" + pad("" + label, 9)
                + ":" + pad("" + value, 5)
                + ":" + pad("" + saldo, 5);
    }
}
