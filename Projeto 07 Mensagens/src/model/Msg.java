package model;

public class Msg {
    private int id;
    private String sender;
    private String text;

    public Msg(int id, String sender, String text){
        this.id = id;
        this.sender = sender;
        this.text = text;
    }

    // Getters and Setters
    public String getSender() {return sender;}
    public void setSender(String sender) {this.sender = sender;}

    public String getText() {return text;}
    public void setText(String text) {this.text = text;}

    // toString
    public String toString(){
        return id + ":" + this.sender + ":" + this.text;
    }

}
