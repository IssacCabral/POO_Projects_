package models;

import java.util.Scanner;

public class View {

    public void run(){
        Scanner scanner = new Scanner(System.in);
        Trampoline trampoline = new Trampoline();

        while(true){
            String[] tokens = scanner.nextLine().split(" ");

            try{
                if(tokens[0].equals("end")){
                    break;
                }else if(tokens[0].equals("arrive")){
                    trampoline.arrive(new Kid(tokens[1], Integer.parseInt(tokens[2])));
                }else if(tokens[0].equals("show")){
                    System.out.println(trampoline);
                }else if(tokens[0].equals("in")){
                    trampoline.in();
                }else if(tokens[0].equals("out")){
                    trampoline.out();
                }else if(tokens[0].equals("remove")){
                    trampoline.remove(tokens[1]);
                }else{
                    System.out.println("Comando invalido");
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println("Provavelmente você esqueceu algum parametro");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
