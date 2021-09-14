package controller;
import model.*;
import java.util.ArrayList;

public class Sistema {
    ArrayList<User> usuarios;

    public Sistema(){
        this.usuarios = new ArrayList<>();
    }

    public void addUser(String userName) throws Exception{
        if(this.getUser(userName) != null){
            throw new Exception("username ja existe");
        }
        usuarios.add(new User(userName));
    }

    public User getUser(String userName) throws Exception{
        for(User user: usuarios){
            if(user.getIdUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }

    public void sendMsg(String sender, String receiver, String text) throws Exception{
        User one = this.getUser(sender);
        User two = this.getUser(receiver);
        if(one == null){
            throw new Exception("Usuario " + sender + " Não existe");
        }
        if(two == null){
            throw new Exception("Usuario " + receiver + " Não existe");
        }

        one.sendMsg(two, text);

    }

    public String readMsgs(String userName) throws Exception{
        User one = this.getUser(userName);
        ArrayList<Msg> output = new ArrayList<>();
        if(one == null){
            System.out.println("usuario " + userName + " não existe");
            return "inbox vazio";
        }
        String saida = "";
        for(Msg msg: one.getInbox()){
            saida += msg + "\n";
        }
        return saida;
    }
}
