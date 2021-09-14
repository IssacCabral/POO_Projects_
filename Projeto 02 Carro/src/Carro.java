import java.util.Scanner;

public class Carro {
    private int tanque;
    private int tanqueMax;
    private int maxPass;
    private int pass;
    private int km;

    public Carro(){
        this.maxPass = 2;
        this.tanqueMax = 100;
    }

    public void in(){
        if(pass >= maxPass){
            System.out.println("Fail: Limite de pessoas atingido");
            return;
        }
        pass++;
    }

    public void out(){
        if(pass == 0){
            System.out.println("fail: não tem ninguém no carro");
            return;
        }
        pass--;
    }

    public void fuel(int qtd){
        if(qtd <= 0){
            System.out.println("Valor inválido!");
            return;
        }
        if(qtd >= tanqueMax)
            tanque = tanqueMax;
        else{
            tanque += qtd;
        }
    }

    public void drive(int qtd){
        if(this.pass == 0){
            System.out.println("Não há ninguém no carro!");
            return;
        }
        if(qtd <= 0){
            System.out.println("Valor inválido!");
            return;
        }
        if(qtd > tanque){
            km += tanque;
            System.out.println("fail: tanque vazio após andar " + tanque + "km");
            tanque = 0;
        }else{
            tanque -= qtd;
            if(tanque < 0){
                tanque = 0;
            }
            km += qtd;
        }

    }

    public String toString(){
        String saida = "Pass: " + pass + " , " + "gas: " + tanque + " , " + "Km: " + km;
        return saida;
    }

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        Carro car = new Carro();

        while(true){
            String line = scann.nextLine();
            String tokens[] = line.split(" ");

            if(tokens[0].equals("end")){
                break;
            }else if(tokens[0].equals("in")){
                car.in();
            }else if(tokens[0].equals("out")){
                car.out();
            }else if(tokens[0].equals("show")){
                System.out.println(car);
            }else if(tokens[0].equals("drive")){
                car.drive(Integer.parseInt(tokens[1]));
            }else if(tokens[0].equals("fuel")){
                car.fuel(Integer.parseInt(tokens[1]));
            }else{
                System.out.println("Comando inválido!");
            }
        }

    }
}
