package view;

import java.util.*;
import model.*;
import controller.Bilheteria;

public class View {
    public void Run(){
        Scanner scanner = new Scanner(System.in);
        Bilheteria bilheteria = new Bilheteria();

        while(true){
            String[] tokens = scanner.nextLine().split(" ");

            try{
                if(tokens[0].equals("end")){
                    break;
                }else if(tokens[0].equals("addPessoa")){
                    bilheteria.addPessoa(tokens[1], tokens[2]);
                }else if(tokens[0].equals("pessoas")){
                    bilheteria.showPessoas();
                }else if(tokens[0].equals("addEvento")){
                    bilheteria.addEvento(tokens[1]);
                }else if(tokens[0].equals("eventos")){
                    bilheteria.showEventos();
                }else if(tokens[0].equals("addSetor")){
                    bilheteria.addSetor(tokens[1], tokens[2], Double.parseDouble(tokens[3]),
                    Integer.parseInt(tokens[4]));
                }else if(tokens[0].equals("vender")){
                    bilheteria.vender(tokens[1], tokens[2], tokens[3]);
                }else if(tokens[0].equals("vendas")){
                    bilheteria.showVendas();
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
