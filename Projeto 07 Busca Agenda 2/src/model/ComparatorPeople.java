package model;

import java.util.Comparator;

public class ComparatorPeople implements Comparator<Contact>{
    // < 0 se arg0 eh menor
    // > 0 se arg0 eh maior
    // == 0 se são iguais

    //Comparando pelo nome das pessoas
    public int compare(Contact arg0, Contact arg1){
        return arg0.getName().compareTo(arg1.getName());
    }
}
