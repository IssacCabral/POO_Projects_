package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;
import controller.Agenda;

public class View {
    public void run(){
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            ArrayList<Fone> fonesAux = new ArrayList<>();

            try{
                if(tokens[0].equals("end")){
                    break;
                }else if(tokens[0].equals("add")){
                    // Como a entrada está no formato "label:numero", tive que quebrar o token em dois
                    for(int i = 2; i < tokens.length; i++){
                        String[] tokenBroken = tokens[i].split(":");
                        Fone fone = new Fone(tokenBroken[0], tokenBroken[1]);
                        fonesAux.add(fone);
                    }
                    // Crio o contato e adiciono os números nele
                    Contact contact = new Contact(tokens[1]);
                    for(Fone fone: fonesAux){
                        contact.addFone(fone);
                    }
                    fonesAux.clear();
                    // Adiciono o contato na agenda
                    agenda.addContact(contact);
                }else if(tokens[0].equals("show")){
                    System.out.println(agenda);
                }else if(tokens[0].equals("star")){
                    agenda.star(tokens[1]);
                }else if(tokens[0].equals("unstar")){
                    agenda.unStar(tokens[1]);
                }else if(tokens[0].equals("starred")){
                    agenda.getStarredContacts();
                }else if(tokens[0].equals("rm")){
                    agenda.removeContact(tokens[1]);
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
