package models;

public class Pass {
    // Attributes
    private int age;
    private String name;

    // Constructor
    public Pass(String name, int age){
        this.name = name;
        this.age = age;
    }

    public boolean isPriority(){
        if(this.age >= 65)
            return true;
        return false;
    }


    // toString
    public String toString(){
        return this.name + ":" + this.age;
    }

    // Getters And setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
