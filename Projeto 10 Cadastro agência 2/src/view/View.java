package view;

import java.util.*;
import model.*;
import controller.BankAgency;

public class View {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        BankAgency bankAgency = new BankAgency();

        while(true){
            String[] tokens = scanner.nextLine().split(" ");

            try{
                if(tokens[0].equals("addCli")){
                    bankAgency.addClient(tokens[1]);
                }else if(tokens[0].equals("show")){
                    System.out.print(bankAgency);
                }else if(tokens[0].equals("deposito")){
                    bankAgency.deposit(Integer.parseInt(tokens[1]), Float.parseFloat(tokens[2]));
                }else if(tokens[0].equals("saque")){
                    bankAgency.withdraw(Integer.parseInt(tokens[1]), Float.parseFloat(tokens[2]));
                }else if(tokens[0].equals("transfer")){
                    int deConta = Integer.parseInt(tokens[1]);
                    int paraConta = Integer.parseInt(tokens[2]);
                    float value = Float.parseFloat(tokens[3]);

                    bankAgency.transfer(deConta, paraConta, value);
                }else if(tokens[0].equals("update")){
                    bankAgency.monthlyUpdate();
                }else if(tokens[0].equals("end")){
                    break;
                }else{
                    System.out.println("Entra inválida!");
                }
            } catch (IndexOutOfBoundsException e){
                System.out.println("Provavelmente vc esqueceu algum parâmetro");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}
