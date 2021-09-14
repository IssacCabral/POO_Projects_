package model;

public class Transaction {
    private String codeName;
    private int id;
    private int value;

    public Transaction(int id, String codeName, int value){
        this.id = id;
        this.codeName = codeName;
        this.value = value;
    }

    public String toString(){
        return "id:" + this.id + " " + this.codeName + ":" + this.value;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
