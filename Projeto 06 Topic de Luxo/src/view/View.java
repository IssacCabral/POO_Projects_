package view;
import controller.Topic;
import models.Pass;

import java.util.Scanner;

public class View {
    public void run(){
        Topic topic = null;
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");

            try{
                if(tokens[0].equals("in")){
                    topic.in(tokens[1], Integer.parseInt(tokens[2]));
                }else if(tokens[0].equals("show")){
                    System.out.println(topic);
                }else if(tokens[0].equals("out")){
                    topic.out(tokens[1]);
                }else if(tokens[0].equals("init")){
                    topic = new Topic(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                }else if(tokens[0].equals("end")){
                    break;
                }else{
                    System.out.println("Entrada Inválida");
                }
            } catch (IndexOutOfBoundsException e){
                System.out.println(e.getMessage() + "Eita!");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
