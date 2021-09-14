import models.*;

public class App {
    public static void main(String[] args) {
        Lapiseira lapiseira = new Lapiseira(0.9);
        lapiseira.inserir(new Grafite(0.9,Dureza.B4,30));
        lapiseira.write(6);
        System.out.println(lapiseira);
        lapiseira.write(3);
    }
}

