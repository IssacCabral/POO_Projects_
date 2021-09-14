package view;
import models.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Contact contact = null;
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");

            try {
                if (tokens[0].equals("end")) {
                    break;
                } else if (tokens[0].equals("init")) {
                    contact = new Contact(tokens[1]);
                } else if (tokens[0].equals("add")) {
                    contact.addFone(new Fone(tokens[1], tokens[2]));
                } else if(tokens[0].equals("rm")){
                    contact.rmFone(Integer.parseInt(tokens[1]));
                } else if(tokens[0].equals("show")){
                    System.out.println(contact);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
