package models;

public class Lapiseira {
    private Grafite grafite = null;
    private double calibre;

    public Lapiseira(double calibre){
        this.calibre = calibre;
    }

    public void setGrafite(Grafite grafite) {
        this.grafite = grafite;
    }

    public boolean inserir(Grafite grafite){
        if(grafite.getCalibre() != this.calibre){
            System.out.println("Fail: Calibre incompatível");
            return false;
        }
        if(this.grafite != null){
            System.out.println("Fail: já existe grafite");
            return false;
        }
        this.grafite = grafite;
        return true;
    }

    public boolean remover(){
        if(this.grafite == null){
            System.out.println("Fail: Não tem nada o que remover");
            return false;
        }
        this.grafite = null;
        return true;
    }

    public void write(int qtdFolhas){
        if(this.grafite == null){
            System.out.println("Não tem grafite");
            return;
        }
        int aux = grafite.getDureza().getDesgaste() * qtdFolhas;
        int aux2 = grafite.getTamanho() - aux;
        if(aux2 <= 0){
            System.out.println("O grafite acabou");
            grafite = null;
            return;
        }
        grafite.setTamanho(aux2);

    }

    @Override
    public String toString(){
        return "calibre: " + this.calibre + ", " + "Grafite: " + this.grafite;
    }

}
