package models;

public class Grafite {
    private double calibre;
    private Dureza dureza;
    private int tamanho;

    public Grafite(double calibre, Dureza dureza, int tamanho){
        this.calibre = calibre;
        this.dureza = dureza;
        this.tamanho = tamanho;
    }

    public double getCalibre() {return calibre;}

    public void setCalibre(double calibre) {this.calibre = calibre;}

    public Dureza getDureza() {return dureza;}

    public void setDureza(Dureza dureza) {this.dureza = dureza;}

    public int getTamanho() {return tamanho;}

    public void setTamanho(int tamanho) {this.tamanho = tamanho;}


    @Override
    public String toString(){
        return "[" + this.calibre + ":" + dureza.getDureza() + ":" + this.tamanho + "]";
    }
}
