import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta conta = new Conta(0);
        System.out.println(conta);
        /*while (true){
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");

            if(tokens[0].equals("end")){
                break;
            }else if(tokens[0].equals("show")){
                System.out.println(conta);
            }else if(tokens[0].equals("init")){
                conta = new Conta(Integer.parseInt(tokens[1]));
            }

        }*/


    }
}
