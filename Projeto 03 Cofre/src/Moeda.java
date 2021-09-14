public enum Moeda {
    M10(0.10, 1),
    M25(0.25, 2),
    M50(0.50, 3),
    M100(1.0, 4);

    private int volume;
    private double valor;

    Moeda(double valor, int volume){
        this.valor = valor;
        this.volume = volume;
    }

    public double getValor() {return valor;}
    public int getVolume() {return volume;}

    public String toString(){
        return "Valor: " + valor + "\nVolume: " + volume + "\n";
    }
}
