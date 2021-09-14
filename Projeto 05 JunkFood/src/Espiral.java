public class Espiral {
    private String name;
    private int qtd;
    private float preco;

    public Espiral(String name, int qtd, float preco){
        this.name = name;
        this.qtd = qtd;
        this.preco = preco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd += qtd;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.qtd + " U : " + this.preco + "RS";
    }
}
