package view;

import controller.Room;
import java.util.Scanner;

public class View {

    public void Run(){
        Scanner scanner = new Scanner(System.in);
        Room room = new Room(0);

        while(true){
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");

            try{
                if(tokens[0].equals("end")){
                    break;
                }else if(tokens[0].equals("show")){
                    System.out.println(room);
                }else if(tokens[0].equals("init")){
                    room = new Room(Integer.parseInt(tokens[1]));
                }else if(tokens[0].equals("reservar")){
                    room.reservar(tokens[1],tokens[2],Integer.parseInt(tokens[3]));
                }else if(tokens[0].equals("cancelar")){
                    room.cancelar(tokens[1]);
                }else{
                    System.out.println("String inválida");
                }
            } catch (IndexOutOfBoundsException e){
                System.out.println("Acho que vc esqueceu de algo");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
