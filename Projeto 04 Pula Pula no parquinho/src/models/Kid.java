package models;

public class Kid {
    //Attributes
    private int age;
    private String name;

    //Constructor
    public Kid(String name, int age){
        this.name = name;
        this.age = age;
    }

    //Getters and Setters
    public int getAge(){return this.age;}
    public String getName(){return this.name;}
    public void setAge(int age) {this.age = age; }
    public void setName(String name) {this.name = name;}

    //toString
    @Override
    public String toString() {
        return  "name=" + name +
                ", age='" + age;
    }

    //Methods

}
