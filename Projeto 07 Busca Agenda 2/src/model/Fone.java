package model;

public class Fone {
    private String id; // oi, tim, claro
    private String number;

    public Fone(String id, String number){
        this.id = id;
        this.number = number;
    }

    public static boolean validateNumber(String number){
        String validNumbers = "0123456789().";
        for(int i = 0; i < number.length(); i++){
            char c = number.charAt(i);
            if(validNumbers.indexOf(c) == -1){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        return this.id + ":" + this.number;
    }

    // Getters and Setters
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getNumber() {return number;}
    public void setNumber(String number) {this.number = number;}
}
