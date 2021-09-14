package models;

import java.util.ArrayList;
import java.util.List;

public class MagicArray {
    private List<Integer> integerList;

    public MagicArray(){
        this.integerList = new ArrayList<>();
    }

    public String toString(){
        return this.integerList + "";
    }

    public void add(int i){
        integerList.add(i);
    }

    public Integer getInd(int ind) throws Exception{
        if(integerList.size() <= ind || ind < 0){
            throw new Exception("Não existe esse índice no Array");
        }
        return integerList.get(ind);
    }

    public void setInd(int ind, int value) throws Exception{
        if(integerList.size() <= ind || ind < 0){
            throw new Exception("Não existe esse índice no Array");
        }
        this.integerList.remove(ind);
        this.integerList.add(ind,value);
    }

    public void rShow(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(int i = integerList.size() - 1; i >= 0; i--){
            if(i == 0){
                sb.append(integerList.get(i));
            }else{
                sb.append(integerList.get(i) + ", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    public void findElement(int[] values){
        String aux = "[ ";

        for(int i = 0; i < values.length; i++){
            if(this.integerList.contains(values[i])){
                aux += integerList.indexOf(values[i]) + " ";
            }else{
                aux += -1 + " ";
            }
        }
        aux += "]";
        System.out.println(aux);
    }

}
