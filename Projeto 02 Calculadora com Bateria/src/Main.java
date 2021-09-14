import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Calculator calculator = null;
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");

            if(tokens[0].equals("end")){
                break;
            }else if(tokens[0].equals("init")){
                calculator = new Calculator(Integer.parseInt(tokens[1]));
            }else if(tokens[0].equals("show")){
                System.out.println(calculator);
            }else if(tokens[0].equals("charge")){
                calculator.chargeBattery(Integer.parseInt(tokens[1]));
            }else if(tokens[0].equals("sum")){
                calculator.sum(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            }else if(tokens[0].equals("div")){
                calculator.division(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            }else{
                System.out.println("Comando inválido!");
            }
        }
    }
}
