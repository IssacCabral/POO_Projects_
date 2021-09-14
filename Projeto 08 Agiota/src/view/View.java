package view;
import controller.Agiota;
import model.*;
import java.util.Scanner;

public class View {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        Agiota agiota = null;

        while(true){
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");

            try{
                if(tokens[0].equals("end")){
                    break;
                }else if(tokens[0].equals("init")){
                    agiota = new Agiota(Integer.parseInt(tokens[1]));
                }else if(tokens[0].equals("addCli")){
                    agiota.addClient(tokens[1], Integer.parseInt(tokens[2]));
                }else if(tokens[0].equals("lend")){
                    agiota.lends(tokens[1], Integer.parseInt(tokens[2]));
                }else if(tokens[0].equals("show")){
                    System.out.println(agiota);
                }else if(tokens[0].equals("receive")){
                    agiota.receive(tokens[1], Integer.parseInt(tokens[2]));
                }else if(tokens[0].equals("kill")){
                    agiota.kill(tokens[1]);
                }
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
