package models;

public class Client {
    //Attributes
    private String name;
    private String fone;


    //Constructor
    public Client(String name, String fone){
        this.name = name;
        this.fone = fone;
    }

    public String toString(){
        return this.name + ":" + this.fone;
    }

    //Getters and Setters
    public String getName() {return name;}
    public String getFone() {return fone;}

    public void setName(String name) {this.name = name;}
    public void setFone(String fone) {this.fone = fone;}
}
