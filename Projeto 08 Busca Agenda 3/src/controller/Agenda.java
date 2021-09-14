package controller;

import model.*;
import java.util.Map;
import java.util.TreeMap;

public class Agenda {
    private Map<String, Contact> contacts;

    public Agenda(){
        this.contacts = new TreeMap<>();
    }

    public void addContact(Contact contact) throws Exception{
        // Se já tiver o contato, adicionar os telefones do contato
        // do parâmetro ao contato da agenda
        if(this.contacts.containsKey(contact.getName())){
            for(Fone fone: contact.getFones()){
                this.contacts.get(contact.getName()).getFones().add(fone);
            }
            return;
        }

        // Se não tiver, adiciona o contato na lista de contatos
        this.contacts.put(contact.getName(), contact);
    }

    public void star(String name) throws Exception{
        if(!this.contacts.containsKey(name)){
            throw new Exception("Fail: contact " + name + " not found");
        }

        if(!this.contacts.get(name).getStarred()){
            this.contacts.get(name).setStarred(true);
        }
    }

    public void unStar(String name) throws Exception{
        if(!this.contacts.containsKey(name)){
            throw new Exception("Fail: contact " + name + " not found");
        }

        if(this.contacts.get(name).getStarred()){
            this.contacts.get(name).setStarred(false);
        }
    }

    public void getStarredContacts(){
        String aux = "";

        for(String key: contacts.keySet()){
            if(contacts.get(key).getStarred()){
                aux += "@ " + contacts.get(key) + "\n";
            }
        }
        System.out.println(aux);
    }

    public void removeContact(String name) throws Exception{
        if(!this.contacts.containsKey(name)){
            throw new Exception("Fail: name " + name + " not found");
        }

        this.contacts.remove(name);
    }

    public String toString(){
        String aux = "";

        for(String key: contacts.keySet()){
            if(contacts.get(key).getStarred()){
                aux += "@ " + contacts.get(key) + "\n";
            }else{
                aux += "- " + contacts.get(key) + "\n";
            }
        }

        return aux;
    }


}
