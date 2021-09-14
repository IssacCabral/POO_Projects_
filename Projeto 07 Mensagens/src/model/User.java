package model;

import java.util.List;
import java.util.ArrayList;

public class User {
    private String idUserName;
    private ArrayList<Msg> inbox;
    private int unreadCount;
    private static int idNextMsg = 0;

    public User(String idUserName){
        this.idUserName = idUserName;
        inbox = new ArrayList<>();
    }

    public void sendMsg(User dest, String text){
        Msg msg = new Msg(idNextMsg, idUserName, text);
        dest.inbox.add(msg);
        idNextMsg += 1;
        dest.unreadCount += 1;
    }

    public ArrayList<Msg> getInbox(){
        ArrayList<Msg> output = new ArrayList<>();
        for(int i = inbox.size() - this.unreadCount; i < inbox.size(); i++){
            output.add(inbox.get(i));
        }
        unreadCount = 0;
        return output;
    }

    public boolean equals(Object obj){
        if(obj instanceof User){
            return this.idUserName.equals(((User)obj).idUserName);
        }
        return false;
    }

    public String getIdUserName() {
        return idUserName;
    }
}
