import models.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pet pet = null;

        while(true){
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");

            if(tokens[0].equals("end")){
                break;
            }else if(tokens[0].equals("init")){
                int energy = Integer.parseInt(tokens[1]);
                int hungry = Integer.parseInt(tokens[2]);
                int shower = Integer.parseInt(tokens[3]);
                pet = new Pet(energy,hungry,shower);
            }else if(tokens[0].equals("show")){
                System.out.println(pet);
            }else if(tokens[0].equals("play")){
                pet.play();
            }else if(tokens[0].equals("eat")){
                pet.eat();
            }else if(tokens[0].equals("shower")){
                pet.shower();
            }else if(tokens[0].equals("sleep")){
                pet.sleep();
            }else{
                System.out.println("Comando inválido");
            }
        }
        scanner.close();
    }
}




