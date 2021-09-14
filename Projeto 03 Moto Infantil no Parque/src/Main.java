import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Motorcycle motorcycle = new Motorcycle(1);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){
                motorcycle = new Motorcycle(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("show")){
                System.out.println(motorcycle);
            }else if(ui[0].equals("in")){
                Person person = new Person(ui[1],Integer.parseInt(ui[2]));
                motorcycle.in(person);
            }else if(ui[0].equals("honk")){
                motorcycle.honk();
            }else if(ui[0].equals("out")){
                motorcycle.out();
            }else if(ui[0].equals("drive")){
                motorcycle.drive(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("buy")){
                motorcycle.buy(Integer.parseInt(ui[1]));
            }
        }
    }
}
