package control;

import model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agenda {
    private ArrayList<Contact> contacts;

    public Agenda(){
        this.contacts = new ArrayList<>();
    }

    private int checkContact(String name){
        for(int i = 0; i < this.contacts.size(); i++){
            if(this.contacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    private boolean checkIndexFoneContact(String name, int index){
        if(index < 0 || index >= contacts.get(checkContact(name)).getFones().size()){
            return false;
        }
        return true;
    }

    public void addContact(Contact contact){
        // Caso já exista um contato com o mesmo nome do contato que está sendo passado como parâmetro
        // Adicionar os contatos do contato parâmetro ao contato da Agenda
        int indexCheckContact = checkContact(contact.getName());
        if(indexCheckContact != -1){
            for(Fone fone: contact.getFones()){
                this.contacts.get(indexCheckContact).getFones().add(fone);
            }
            return;
        }
        // Caso ainda não exista, adicionar o contato na lista de contatos
        this.contacts.add(contact);
    }

    public void rmFone(String name, int index) throws Exception{
        if(checkContact(name) == -1){
            throw new Exception("Fail: Não existe contato com o nome " + name);
        }
        if(!checkIndexFoneContact(name, index)){
            throw new Exception("Fail: index " + index + "para o contato " + name + " inválido");
        }
        this.contacts.get(checkContact(name)).getFones().remove(index);
    }

    public void rmContact(String name) throws Exception{
        if(checkContact(name) == -1){
            throw new Exception("fail: Não existe contato com o nome " + name);
        }
        this.contacts.remove(checkContact(name));
    }

    public String toString(){
        Collections.sort(this.contacts, new ComparatorPeople());
        String aux = "";

        for(Contact contact: this.contacts){
            aux += contact + "\n";
        }
        return aux;
    }

    public ArrayList<Contact> search(String find){
        ArrayList<Contact> solver = new ArrayList<Contact>();

        Pattern patter = Pattern.compile(find);
        for(Contact obj : contacts) {
            Matcher matcher = patter.matcher(obj.toString());
            if(matcher.find())
                solver.add(obj);
        }

        return solver;
    }

}
