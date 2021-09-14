package models;

public enum Dureza {
    HB("HB",1),
    B2("2B",2),
    B4("4B", 4),
    B6("6B",6);

    private int desgaste;
    private String dureza;

    Dureza(String dureza,int desgaste) {
        this.dureza = dureza;
        this.desgaste = desgaste;
    }

    public int getDesgaste() {return desgaste;}
    public String getDureza() {return dureza;}

}
